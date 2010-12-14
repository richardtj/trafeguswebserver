package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TipoTransporteZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.TipoTransporteSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
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
		public function solicitaListaTipoTransporte():void
		{
			if(MainModel.getInstance().tipoTransporteArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaTipoTransporte(solicitaListaTipoTransporteResultHandler);
			}
		}
		public function atualizaListaTipoTransporte():void
		{
			TrafegusWS.getIntance().solicitaListaTipoTransporte(solicitaListaTipoTransporteResultHandler);
		}
		private function solicitaListaTipoTransporteResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().tipoTransporteArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var tipoTransporte:TipoTransporteVO = new TipoTransporteVO();
				tipoTransporte.setTipoTransporteVO(obj);
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
				Alert.show("Nenhum tipo de viagem selecionado.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}