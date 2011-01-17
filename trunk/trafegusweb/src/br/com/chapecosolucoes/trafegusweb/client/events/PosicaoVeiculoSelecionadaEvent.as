package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import flash.events.Event;
	
	public class PosicaoVeiculoSelecionadaEvent extends Event
	{
		public static const POSICAO_VEICULO_SELECIONADA_EVENT:String = "posicaoVeiculoSelecionadaEvent";
		public var posicaoVeiculoVO:PosicaoVeiculoVO;
		public function PosicaoVeiculoSelecionadaEvent(type:String,posicaoVeiculoVO:PosicaoVeiculoVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.posicaoVeiculoVO = posicaoVeiculoVO;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new PosicaoVeiculoSelecionadaEvent(type,posicaoVeiculoVO,bubbles,cancelable);
		}
	}
}