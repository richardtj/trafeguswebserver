package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PosicaoVeiculoZoom;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	import mx.managers.PopUpManagerChildList;

	public class DistanciaEntreVeiculosController
	{
		public function DistanciaEntreVeiculosController()
		{
		}
		public var view:DistanciaEntreVeiculosView;
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);			
		}
		public function veiculoZoomDispatcher():void
		{
			var posicaoVeiculoZoom:PosicaoVeiculoZoom = new PosicaoVeiculoZoom();
			//posicaoVeiculoZoom.addEventListener(SelectedVehicleEvent.SELECTED_VEHICLE_EVENT,selectedVehicleEventHandler);
			PopUpManager.addPopUp(posicaoVeiculoZoom,DisplayObject(FlexGlobals.topLevelApplication),false,PopUpManagerChildList.POPUP);
			PopUpManager.centerPopUp(posicaoVeiculoZoom);
		}
		public function veiculosSelecionados():void
		{
			
		}
	}
}