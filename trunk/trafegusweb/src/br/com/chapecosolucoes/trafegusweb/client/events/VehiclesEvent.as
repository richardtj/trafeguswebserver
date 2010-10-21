package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class VehiclesEvent extends Event
	{
		public static const VEHICLES_RECEIVED_EVENT:String = "vehiclesReceivedEvent";
		public static const VEHICLE_SELECTED_EVENT:String = "vehicleSelectedEvent";
		
		public function VehiclesEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new VehiclesEvent(VEHICLES_RECEIVED_EVENT);
		}
	}
}