package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciaEVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import flash.events.Event;
	
	public class DistanciaEntreReferenciaEVeiculoSelecionadoEvent extends Event
	{
		public static const DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_SELECIONADA_EVENT:String = "distanciaEntreReferenciaEVeiculoSelecionadaEvent";
		public static const DISTANCIA_ENTRE_REFERENCIA_E_VEICULO_ADICIONADA_EVENT:String = "distanciaEntreReferenciaEVeiculoAdicionadaEvent";
		public var distanciaEntreReferenciaEVeiculoVO:DistanciaDeAteReferenciaEVeiculoVO;
		public function DistanciaEntreReferenciaEVeiculoSelecionadoEvent(type:String,distanciaEntreReferenciaEVeiculoVO:DistanciaDeAteReferenciaEVeiculoVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.distanciaEntreReferenciaEVeiculoVO = distanciaEntreReferenciaEVeiculoVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new DistanciaEntreReferenciaEVeiculoSelecionadoEvent(type,distanciaEntreReferenciaEVeiculoVO,bubbles,cancelable);
		}
	}
}