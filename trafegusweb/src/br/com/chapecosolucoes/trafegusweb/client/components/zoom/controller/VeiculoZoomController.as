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
			TrafegusWS.getIntance().solicitaListaVeiculos(solicitaListaVeiculosResultHandler);
		}
		public function showVehiclesDetails(event:ListEvent):void
		{
			
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
		public function veiculoSelecionado(event:MouseEvent):void
		{
			var selectedVehicleEvent:SelectedVehicleEvent = new SelectedVehicleEvent(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,VeiculoVO(this.view.grid.selectedItem));
			this.view.dispatchEvent(selectedVehicleEvent);
			this.closeHandler();
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}