package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.PaginableComponent;
	
	import flash.events.Event;
	
	public class PaginableEvent extends Event
	{
		public static const NEXT:String = "next";
		public static const PREV:String = "prev";
		public static const FIRST:String = "first";
		public static const LAST:String = "last";
		public function PaginableEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new PaginableEvent(type);
		}
	}
}