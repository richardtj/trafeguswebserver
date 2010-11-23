package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class VehiclesEvent extends Event
	{
		public static const VEHICLES_RECEIVED_EVENT:String = "vehiclesReceivedEvent";
		public static const VEHICLE_SELECTED_EVENT:String = "vehicleSelectedEvent";
		public var index:int = 0;
		public function VehiclesEvent(type:String, index:int=0, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.index = index;
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new VehiclesEvent(VEHICLES_RECEIVED_EVENT,index);
		}
	}
}