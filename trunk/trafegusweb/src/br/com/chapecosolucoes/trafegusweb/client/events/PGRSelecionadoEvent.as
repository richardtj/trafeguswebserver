package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO;
	
	import flash.events.Event;
	
	public class PGRSelecionadoEvent extends Event
	{
		public static const PGR_SELECIONADO_EVENT:String = "pgrSelecionadoEvent";
		public var pgr:PGRVO;
		public function PGRSelecionadoEvent(type:String,pgr:PGRVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.pgr = pgr;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new PGRSelecionadoEvent(type,pgr,bubbles,cancelable);
		}
	}
}