package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TipoTransporteVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class TipoTransporteZoomController
	{
		public function TipoTransporteZoomController()
		{
		}
		public var view:TipoTransporteZoom;
		public function tipoTransporteFilterFunction(item:Object):Boolean
		{
			return (String(TipoTransporteVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TipoTransporteVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaTipoTransporte(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaTipoTransporte(solicitaListaTipoTransporteResultHandler,event.paginaAtual);
		}
		public function atualizaListaTipoTransporte():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaTipoTransporte();
			TrafegusWS.getInstance().solicitaListaTipoTransporte(solicitaListaTipoTransporteResultHandler,0);
		}
		private function solicitaListaTipoTransporteResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().tipoTransporteArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var tipoTransporte:TipoTransporteVO = new TipoTransporteVO();
				tipoTransporte.setTipoTransporteVO(obj);
				tipoTransporte.count = i++;
				MainModel.getInstance().tipoTransporteArray.addItem(tipoTransporte);
			}
		}
		public function tipoTransporteSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var tipoTransporteEvent:TipoTransporteSelecionadoEvent = new TipoTransporteSelecionadoEvent(TipoTransporteSelecionadoEvent.TIPO_TRANSPORTE_SELECIONADO_EVENT,TipoTransporteVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(tipoTransporteEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum tipo de viagem selecionado.");
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().tipoTransporteArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaTipoTransporte():void
		{
			TrafegusWS.getInstance().solicitaTotalListaTipoTransporte(solicitaTotalListaTipoTransporteResultHandler);
		}
		private function solicitaTotalListaTipoTransporteResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaTipoTransporte = int(obj.total.toString());
			}
		}
		public function advancedSearchTipoTransporteEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraTipoTransporte(procuraTipoTransporteResultHandler,event.genericVO);
		}
		private function procuraTipoTransporteResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaTipoTransporte = 1;
			this.solicitaListaTipoTransporteResultHandler(event);
		}
	}
}