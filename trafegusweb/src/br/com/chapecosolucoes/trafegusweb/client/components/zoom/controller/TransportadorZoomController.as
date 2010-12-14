package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.TransportadoresZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.TransportadorSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.events.ListEvent;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class TransportadorZoomController
	{
		public function TransportadorZoomController()
		{
		}
		public var view:TransportadoresZoom;
		public function transportadoresFilterFunction(item:Object):Boolean
		{
			return (String(TransportadorVO(item).cnpj).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).cpf).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).ie).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).nome).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).rg).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(TransportadorVO(item).site).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaTransportadores():void
		{
			if(MainModel.getInstance().transportadoresArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaTransportadores(solicitaListaTransportadoresResultHandler);
			}
		}
		public function atualizaListaTransportadores():void
		{
			TrafegusWS.getIntance().solicitaListaTransportadores(solicitaListaTransportadoresResultHandler);
		}
		private function solicitaListaTransportadoresResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().transportadoresArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var transportador:TransportadorVO = new TransportadorVO();
				transportador.setTransportadorVO(obj);
				MainModel.getInstance().transportadoresArray.addItem(transportador);
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
		public function transportadorSelecionado(event:MouseEvent):void
		{
			if(this.view.grid.selectedItem != null)
			{
				var transportadorEvent:TransportadorSelecionadoEvent = new TransportadorSelecionadoEvent(TransportadorSelecionadoEvent.TRANSPORTADOR_SELECIONADO_EVENT,TransportadorVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(transportadorEvent);
				this.closeHandler();
			}
			else
			{
				Alert.show("Nenhuma transportador selecionado.");
			}
		}
	}
}