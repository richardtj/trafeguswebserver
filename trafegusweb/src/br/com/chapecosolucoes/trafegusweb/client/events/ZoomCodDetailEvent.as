package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class ZoomCodDetailEvent extends Event
	{
		public static const CLICK:String = "clickZoom";
		public function ZoomCodDetailEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new ZoomCodDetailEvent(CLICK);
		}
	}
}