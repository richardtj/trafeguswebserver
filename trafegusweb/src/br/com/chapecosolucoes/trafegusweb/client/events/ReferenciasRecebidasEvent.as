package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;
	
	public class ReferenciasRecebidasEvent extends Event
	{
		public static const REFERENCIAS_RECEBIDAS_EVENT:String = "referenciasRecebidasEvent";
		public function ReferenciasRecebidasEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new ReferenciasRecebidasEvent(type);
		}
	}
}