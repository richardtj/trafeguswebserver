package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.TipoParadaVO;
	
	import flash.events.Event;
	
	public class TipoParadaSelecionadoEvent extends Event
	{
		public static const TIPO_PARADA_SELECIONADO_EVENT:String = "tipoParadaSelecionadoEvent";
		public var tipoParada:TipoParadaVO;
		public function TipoParadaSelecionadoEvent(type:String,tipoParada:TipoParadaVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.tipoParada = tipoParada;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new  TipoParadaSelecionadoEvent(type,tipoParada);
		}
	}
}