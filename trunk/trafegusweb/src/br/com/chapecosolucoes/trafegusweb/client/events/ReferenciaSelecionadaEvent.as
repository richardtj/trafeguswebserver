package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import flash.events.Event;
	
	public class ReferenciaSelecionadaEvent extends Event
	{
		public static const REFERENCIA_SELECIONADA_EVENT:String = "referenciaSelecionadaEvent";
		public var referenciaVO:ReferenciaVO;
		public function ReferenciaSelecionadaEvent(type:String,referencia:ReferenciaVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.referenciaVO = referencia;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new ReferenciaSelecionadaEvent(type,referenciaVO,bubbles,cancelable);
		}
	}
}