package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.EmbarcadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.EmbarcadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.EmbarcadorDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	import flash.media.Video;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class EmbarcadoresZoomController
	{
		public function EmbarcadoresZoomController()
		{
		}
		public var view:EmbarcadoresZoom;
		public function embarcadoresFilterFunction(item:Object):Boolean
		{
			return (String(EmbarcadorVO(item).cnpj).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).ie).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).nome).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(EmbarcadorVO(item).site).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
			
		}
		public function solicitaListaEmbarcadores(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaEmbarcadores(solicitaListaEmbarcadoresResultEvent,event.paginaAtual);
		}
		public function atualizaListaEmbarcadores():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaEmbarcadores();
			TrafegusWS.getInstance().solicitaListaEmbarcadores(solicitaListaEmbarcadoresResultEvent,0);
		}
		private function solicitaListaEmbarcadoresResultEvent(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().embarcadoresArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var embarcador:EmbarcadorVO = new EmbarcadorVO();
				embarcador.setEmbarcadorVO(obj);
				embarcador.count = i++;
				MainModel.getInstance().embarcadoresArray.addItem(embarcador);
			}
		}
		public function embarcadorSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var embarcadorEvent:EmbarcadorSelecionadoEvent = new EmbarcadorSelecionadoEvent(EmbarcadorSelecionadoEvent.EMBARCADOR_SELECIONADO_EVENT,EmbarcadorVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(embarcadorEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum embarcador selecionado.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().embarcadoresArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaEmbarcadores():void
		{
			TrafegusWS.getInstance().solicitaTotalListaEmbarcadores(solicitaTotalListaEmbarcadoresResultHandler);
		}
		private function solicitaTotalListaEmbarcadoresResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaEmbarcadores = int(obj.total.toString());
			}
		}
		public function embarcadorSelecionadoEventHandler(event:EmbarcadorSelecionadoEvent):void
		{
			event.stopImmediatePropagation();
			this.embarcadorSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			EmbarcadorDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchEmbarcadoresEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraEmbarcadores(procuraEmbarcadoresResultHandler,event.genericVO);
		}
		private function procuraEmbarcadoresResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaEmbarcadores = 1;
			this.solicitaListaEmbarcadoresResultEvent(event);
		}
	}
}