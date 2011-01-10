package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class ZoomCodDetailEvent extends Event
	{
		public static const CLICK:String = "clickZoom";
		public static const TAB:String = "tabZoom";
		public var cod:String;
		public function ZoomCodDetailEvent(type:String,cod:String="", bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.cod = cod;
			super(type, bubbles, cancelable);
		}
		public override function clone():Event 
		{
			return new ZoomCodDetailEvent(type,cod);
		}
	}
}