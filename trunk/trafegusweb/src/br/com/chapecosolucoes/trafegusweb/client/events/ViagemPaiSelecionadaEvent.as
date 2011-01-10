package br.com.chapecosolucoes.trafegusweb.client.events
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO;
	
	import flash.events.Event;
	
	public class ViagemPaiSelecionadaEvent extends Event
	{
		public static const VIAGEM_PAI_SELECIONADA_EVENT:String = "viagemPaiSelecionadaEvent";
		public var viagemPai:ViagemPaiVO;
		public function ViagemPaiSelecionadaEvent(type:String,viagemPai:ViagemPaiVO, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			this.viagemPai = viagemPai;
			super(type, bubbles, cancelable);
		}
		override public function clone():Event
		{
			return new ViagemPaiSelecionadaEvent(type,viagemPai, bubbles, cancelable);
		}
	}
}