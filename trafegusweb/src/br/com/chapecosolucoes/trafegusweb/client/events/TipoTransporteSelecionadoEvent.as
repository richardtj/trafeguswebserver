package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.TipoTransporteVO;
	
	import flash.events.Event;
	
	public class TipoTransporteSelecionadoEvent extends Event
	{
		public static const TIPO_TRANSPORTE_SELECIONADO_EVENT:String = "tipoTransporteSelecionadoEvent";
		public var tipoTransporte:TipoTransporteVO;
		public function TipoTransporteSelecionadoEvent(type:String,tipoTransporte:TipoTransporteVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.tipoTransporte = tipoTransporte;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new  TipoTransporteSelecionadoEvent(type,tipoTransporte);
		}
	}
}