package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class CloseAppEvent extends Event
	{
		public static const CLOSE_APP_EVENT:String = "closeAppEvent";
		public function CloseAppEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new CloseAppEvent(type,bubbles,cancelable);
		}
	}
}