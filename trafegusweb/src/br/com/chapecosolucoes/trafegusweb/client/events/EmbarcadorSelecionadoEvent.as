package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
	
	import flash.events.Event;
	
	public class EmbarcadorSelecionadoEvent extends Event
	{
		public static const EMBARCADOR_SELECIONADO_EVENT:String = "embarcadorSelecionadoEvent";
		public var embarcador:EmbarcadorVO;
		public function EmbarcadorSelecionadoEvent(type:String,embarcador:EmbarcadorVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.embarcador = embarcador;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new EmbarcadorSelecionadoEvent(type,embarcador,bubbles,cancelable);
		}
	}
}