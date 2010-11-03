package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class VehiclesHistoricEvent extends Event
	{
		public static const ROUTE_RECEIVED_EVENT:String = "routeReceivedEvent";
		
		public function VehiclesHistoricEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new VehiclesHistoricEvent(ROUTE_RECEIVED_EVENT);
		}
	}
}