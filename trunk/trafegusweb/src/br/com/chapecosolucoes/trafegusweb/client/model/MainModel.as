package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	public final class MainModel
	{
		private static var instance:MainModel;
		/*[ArrayElementType("br.com.chapecosolucoes.trafegusweb.vo.DataPos")]
		public var dpPosicao:ArrayCollection;*/
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.vo.DataMsg")]
		public var dpMensagens:ArrayCollection;
		public var mapReady:Boolean = false;
		public var veiculoSelecionado:String;
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO")]
		public var posVeiculosArray:ArrayCollection;
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO")]
		public var historicoPosicoesVeiculosArray:ArrayCollection;
		
		public var posicaoVeiculoVO:PosicaoVeiculoVO;

		public function MainModel(enforcer:SingletonEnforcer)
		{
			if (enforcer == null)
			{
				throw new Error("Só pode haver uma instância de [MainModel]");
			}
		}

		public static function getInstance():MainModel
		{
			if (instance == null)
				instance = new MainModel(new SingletonEnforcer());
			return instance;
		}

	}
}

class SingletonEnforcer
{

}