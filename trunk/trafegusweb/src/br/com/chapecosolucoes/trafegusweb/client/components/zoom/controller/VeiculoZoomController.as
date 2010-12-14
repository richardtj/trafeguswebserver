package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.VeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedVehicleEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.events.ListEvent;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class VeiculoZoomController
	{
		public function VeiculoZoomController()
		{
		}
		public var view:VeiculoZoom;
		public function solicitaListaVeiculos():void
		{
			if(MainModel.getInstance().veiculosArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaVeiculos(solicitaListaVeiculosResultHandler);
			}
		}
		public function atualizaListaVeiculos():void
		{
			TrafegusWS.getIntance().solicitaListaVeiculos(solicitaListaVeiculosResultHandler);
		}
		private function solicitaListaVeiculosResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().veiculosArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var veiculo:VeiculoVO = new VeiculoVO(obj);
				MainModel.getInstance().veiculosArray.addItem(veiculo);
			}
		}
		public function veiculosFilterFunction(item:Object):Boolean
		{
			return (String(VeiculoVO(item).cod).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
					(String(VeiculoVO(item).vehiclePlate).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
					(String(VeiculoVO(item).desc).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function veiculoSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var selectedVehicleEvent:SelectedVehicleEvent = new SelectedVehicleEvent(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,VeiculoVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(selectedVehicleEvent);
				this.closeHandler();
			}
			else
			{
				Alert.show("Nenhum veiculo selecionado.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}