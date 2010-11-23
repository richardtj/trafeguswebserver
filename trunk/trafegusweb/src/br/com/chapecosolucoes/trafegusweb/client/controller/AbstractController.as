package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
	import br.com.chapecosolucoes.trafegusweb.client.view.AbstractView;
	
	import flash.events.MouseEvent;

	public class AbstractController
	{
		public function AbstractController()
		{
		}
		public var view:AbstractView;
		public function veiculoSelecionadoHandler(event:MouseEvent):void
		{
			var vehicleEvent:VehiclesEvent = new VehiclesEvent(VehiclesEvent.VEHICLE_SELECTED_EVENT);
			this.view.dispatchEvent(vehicleEvent);
		}
	}
}