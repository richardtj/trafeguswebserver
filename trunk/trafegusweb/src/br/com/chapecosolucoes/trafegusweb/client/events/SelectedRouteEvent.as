package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
	
	import flash.events.Event;
	
	public class SelectedRouteEvent extends Event
	{
		public static const SELECTED_ROUTE_EVENT:String = "selectedRouteEvent";
		public var route:RouteVO;
		public function SelectedRouteEvent(type:String,route:RouteVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.route = route;
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new SelectedRouteEvent(SELECTED_ROUTE_EVENT,route,bubbles,cancelable);
		}
	}
}