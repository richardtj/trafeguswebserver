package br.com.chapecosolucoes.trafegusweb.client.model
{
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosEmbarcadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosTransportadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
	
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
		
		public var posicaoVeiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO();
		
		public var dadosMotoristaVO:DadosMotoristaVO = new DadosMotoristaVO();
		
		public var dadosVeiculoVO:DadosVeiculoVO = new DadosVeiculoVO();
		
		public var dadosRotaVO:RouteVO = new RouteVO();
		
		public var dadosEmbarcadorVO:DadosEmbarcadorVO = new DadosEmbarcadorVO();
		
		public var dadosTransportadorVO:DadosTransportadorVO = new DadosTransportadorVO();
		
		public var codEmpresa:int = 1457;
		
		public var veiculosX:int = 0;
		
		public var veiculosY:int = 20;
		
		public var leftToRightEnabled:Boolean = true;
		
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO")]
		public var veiculosViagemArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
		public var veiculosArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO")]
		public var motoristasArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO")]
		public var rotasArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO")]
		public var embarcadoresArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
		public var veiculosSelecionadosArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO")]
		public var transportadoresArray:ArrayCollection = new ArrayCollection();

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