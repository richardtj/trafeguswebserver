package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO;
	
	import flash.events.Event;
	
	public class SelectedLocalEvent extends Event
	{
		public static const SELECTED_LOCAL_EVENT:String = "selectedLocalEvent";
		public var local:LocalVO;
		public function SelectedLocalEvent(type:String,local:LocalVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.local = local;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new SelectedLocalEvent(type,local,bubbles,cancelable);
		}
	}
}