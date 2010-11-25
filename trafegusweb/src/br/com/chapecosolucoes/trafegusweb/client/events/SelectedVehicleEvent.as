package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO;
	
	import flash.events.Event;
	
	public class SelectedVehicleEvent extends Event
	{
		public static const SELECTED_VEHICLE_EVENT:String = "selectedVehicleEvent";
		public var veiculo:VeiculoVO;
		public function SelectedVehicleEvent(type:String, veiculo:VeiculoVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.veiculo = veiculo;
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new SelectedVehicleEvent(SELECTED_VEHICLE_EVENT,veiculo);
		}
	}
}