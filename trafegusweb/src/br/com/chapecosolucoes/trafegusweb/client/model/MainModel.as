package br.com.chapecosolucoes.trafegusweb.client.model
{
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosEmbarcadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosLocalVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosPGRVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosTransportadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosViagemPaiVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.SolicitacaoMonitoramentoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO;
    
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

        public var codTerminais:String = "";

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

        public var dadosLocalVO:DadosLocalVO = new DadosLocalVO();

        public var dadosPGRVO:DadosPGRVO = new DadosPGRVO();

        public var dadosViagemPaiVO:ViagemPaiVO = new ViagemPaiVO();

        public var solicitacaoMonitoramentoVO:SolicitacaoMonitoramentoVO = new SolicitacaoMonitoramentoVO();

        public var codEmpresa:int = 0;

        public var veiculosX:int = 0;

        public var veiculosY:int = 20;

        public var leftToRightEnabled:Boolean = true;

        public var totalDadosGrid:int = 0;

        public var totalListaLocais:int = 0;

        public var totalListaEmbarcadores:int = 0;

        public var totalListaMotoristas:int = 0;

        public var totalListaPGR:int = 0;

        public var totalListaRotas:int = 0;

        public var totalListaTipoTransporte:int = 0;

        public var totalListaTransportadores:int = 0;

        public var totalListaVeiculos:int = 0;

        public var totalListaViagemPai:int = 0;

        public var totalHistoricoPosicoes:int = 0;

        public var totalVeiculosViagem:int = 0;

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
        public var carretasSelecionadasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO")]
        public var transportadoresArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO")]
        public var locaisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO")]
        public var paradasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TipoTransporteVO")]
        public var tipoTransporteArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
        public var carretasDisponiveisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO")]
        public var pgrArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO")]
        public var viagemPaiArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO")]
        public var terminaisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO")]
        public var terminaisDefeituososArray:ArrayCollection = new ArrayCollection();

		public var classesReferencia:ArrayCollection = new ArrayCollection();
		public var Referencias:ArrayCollection = new ArrayCollection();
		
		
<<<<<<< .mine
		public var dadosMotoristaVO:DadosMotoristaVO = new DadosMotoristaVO();
		
		public var dadosVeiculoVO:DadosVeiculoVO = new DadosVeiculoVO();
		
		public var dadosRotaVO:RouteVO = new RouteVO();
		
		public var dadosEmbarcadorVO:DadosEmbarcadorVO = new DadosEmbarcadorVO();
		
		public var dadosTransportadorVO:DadosTransportadorVO = new DadosTransportadorVO();
		
		public var dadosLocalVO:DadosLocalVO = new DadosLocalVO();
		
		public var dadosPGRVO:DadosPGRVO = new DadosPGRVO();
		
		public var dadosViagemPaiVO:ViagemPaiVO = new ViagemPaiVO();
		
		public var solicitacaoMonitoramentoVO:SolicitacaoMonitoramentoVO = new SolicitacaoMonitoramentoVO();
		
		public var codEmpresa:int = 0;
		
		public var codUsuario:int = 0;
		
		public var veiculosX:int = 0;
		
		public var veiculosY:int = 20;
		
		public var leftToRightEnabled:Boolean = true;
		
		public var totalDadosGrid:int=0;
		
		public var totalListaLocais:int=0;
		
		public var totalListaEmbarcadores:int=0;
		
		public var totalListaMotoristas:int=0;
		
		public var totalListaPGR:int = 0;
		
		public var totalListaRotas:int=0;
		
		public var totalListaTipoTransporte:int=0;
		
		public var totalListaTransportadores:int=0;
		
		public var totalListaVeiculos:int=0;
		
		public var totalListaViagemPai:int=0;
		
		public var totalHistoricoPosicoes:int=0;
		
		public var totalVeiculosViagem:int=0;
		
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
		public var carretasSelecionadasArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO")]
		public var transportadoresArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO")]
		public var locaisArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO")]
		public var paradasArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TipoTransporteVO")]
		public var tipoTransporteArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
		public var carretasDisponiveisArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO")]
		public var pgrArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO")]
		public var viagemPaiArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO")]
		public var terminaisArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO")]
		public var terminaisDefeituososArray:ArrayCollection = new ArrayCollection();
=======
        public function MainModel(enforcer:SingletonEnforcer)
        {
            if (enforcer == null)
            {
                throw new Error("Só pode haver uma instância de [MainModel]");
            }
        }
>>>>>>> .r160

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