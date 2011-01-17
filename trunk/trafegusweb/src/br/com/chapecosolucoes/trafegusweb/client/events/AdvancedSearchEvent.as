package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class AdvancedSearchEvent extends Event
	{
		public static const ADVANCED_SEARCH_EVENT:String = "advancedSearchEvent";
		public function AdvancedSearchEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new AdvancedSearchEvent(type,bubbles,cancelable);
		}
	}
}