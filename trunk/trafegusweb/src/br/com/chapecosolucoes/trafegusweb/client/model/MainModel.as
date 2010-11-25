package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosVeiculoVO;
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
		public var veiculoSelecionado:String = "";
		public var historicoSelecionado:String = "";
		public var viagemSelecionada:String = "";
		public var zoomFilter:String = "";
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO")]
		public var posVeiculosArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO")]
		public var historicoPosicoesVeiculosArray:ArrayCollection = new ArrayCollection();
		
		public var posicaoVeiculoVO:PosicaoVeiculoVO;
		
		public var dadosMotoristaVO:DadosMotoristaVO = new DadosMotoristaVO();
		
		public var dadosVeiculoVO:DadosVeiculoVO = new DadosVeiculoVO();
		
		public var codEmpresa:int = 1457;
		
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO")]
		public var veiculosViagemArray:ArrayCollection = new ArrayCollection();
		
		public var veiculosArray:ArrayCollection = new ArrayCollection();

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