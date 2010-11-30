package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO;
	
	import flash.events.Event;
	
	public class TransportadorSelecionadoEvent extends Event
	{
		public static const TRANSPORTADOR_SELECIONADO_EVENT:String = "transportadorSelecionadoEvent";
		public var transportador:TransportadorVO;
		public function TransportadorSelecionadoEvent(type:String,transportador:TransportadorVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.transportador = transportador;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new TransportadorSelecionadoEvent(type,transportador);
		}
	}
}