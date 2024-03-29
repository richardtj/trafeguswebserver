package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PGRZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.PGRDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	
	import org.flexunit.runner.Result;
	
	import spark.components.PopUpAnchor;

	public class PGRZoomController
	{
		public function PGRZoomController()
		{
		}
		public var view:PGRZoom;
		public function pgrFilterFunction(item:Object):Boolean
		{
			return (String(PGRVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PGRVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PGRVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaPGR(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaPGR(solicitaListaPGRResultHandler,event.paginaAtual);
		}
		public function atualizaListaPGR():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaPGR();
			TrafegusWS.getInstance().solicitaListaPGR(solicitaListaPGRResultHandler,0);
		}
		private function solicitaListaPGRResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().pgrArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var pgr:PGRVO = new PGRVO();
				pgr.setPGRVO(obj);
				pgr.count = i++
				MainModel.getInstance().pgrArray.addItem(pgr);
			}
		}
		public function pgrSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var pgrEvent:PGRSelecionadoEvent = new PGRSelecionadoEvent(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,PGRVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(pgrEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum PGR selecionado.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().pgrArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaPGR():void
		{
			TrafegusWS.getInstance().solicitaTotalListaPGR(solicitaTotalListaPGRResultHandler);
		}
		private function solicitaTotalListaPGRResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaPGR = int(obj.total.toString());
			}
		}
		public function pgrSelecionadoEventHandler(event:PGRSelecionadoEvent):void
		{
			event.stopImmediatePropagation();
			this.pgrSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			PGRDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchPGREventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraPGR(procuraPGRResultHandler,event.genericVO);
		}
		private function procuraPGRResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaPGR = 1;
			this.solicitaListaPGRResultHandler(event);
		}
	}
}