package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ViagemPaiZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ViagemPaiSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.ViagemPaiDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class ViagemPaiZoomController
	{
		public function ViagemPaiZoomController()
		{
		}
		public var view:ViagemPaiZoom;
		public function solicitaListaViagemPai(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaViagemPai(solicitaListaViagemPaiResultHandler,event.paginaAtual);
		}
		public function inicializaListaViagemPai():void{
			if(MainModel.getInstance().viagemPaiArray.length == 0)
			{
				this.atualizaListaViagemPai();
			}
		}
		public function atualizaListaViagemPai():void
		{
			this.solicitaTotalListaViagemPai();
			TrafegusWS.getInstance().solicitaListaViagemPai(solicitaListaViagemPaiResultHandler,0);
		}
		private function solicitaListaViagemPaiResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().viagemPaiArray.removeAll();
			this.view.paginable.paginaAtual = 1;
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var viagemPai:ViagemPaiVO = new ViagemPaiVO();
				viagemPai.setViagemPaiVO(obj);
				viagemPai.count = i++;
				MainModel.getInstance().viagemPaiArray.addItem(viagemPai);
			}
		}
		public function viagemPaiFilterFunction(item:Object):Boolean
		{
			return (String(ViagemPaiVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ViagemPaiVO(item).previsaoFim).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ViagemPaiVO(item).previsaoInicio).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function viagemPaiSelecionada():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var viagemPaiSelecionadaEvent:ViagemPaiSelecionadaEvent = new ViagemPaiSelecionadaEvent(ViagemPaiSelecionadaEvent.VIAGEM_PAI_SELECIONADA_EVENT,ViagemPaiVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(viagemPaiSelecionadaEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma Viagem Selecionada.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().viagemPaiArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaViagemPai():void
		{
			TrafegusWS.getInstance().solicitaTotalListaViagemPai(solicitaTotalListaViagemPaiResultHandler);
		}
		private function solicitaTotalListaViagemPaiResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaViagemPai = int(obj.total.toString());
			}
		}
		public function viagemPaiSelecionadaEventHandler(event:ViagemPaiSelecionadaEvent):void
		{
			event.stopImmediatePropagation();
			this.viagemPaiSelecionada();
		}
		public function mouseOverEventHandler():void
		{
			ViagemPaiDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchViagemPaiEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraViagemPai(procuraViagemPaiResultHandler,event.genericVO);
		}
		private function procuraViagemPaiResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaViagemPai = 1;
			this.solicitaListaViagemPaiResultHandler(event);
		}
	}
}