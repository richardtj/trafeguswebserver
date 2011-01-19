package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class AdvancedSearchEvent extends Event
	{
		public static const ADVANCED_SEARCH_EVENT:String = "advancedSearchEvent";
		public var genericVO:Object
		public function AdvancedSearchEvent(type:String,genericVO:Object, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.genericVO = genericVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new AdvancedSearchEvent(type,genericVO,bubbles,cancelable);
		}
	}
}