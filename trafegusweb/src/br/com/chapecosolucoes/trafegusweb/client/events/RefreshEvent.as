package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class RefreshEvent extends Event
	{
		public static const REFRESH_EVENT:String = "refreshEvent";
		public function RefreshEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new RefreshEvent(type);
		}
	}
}