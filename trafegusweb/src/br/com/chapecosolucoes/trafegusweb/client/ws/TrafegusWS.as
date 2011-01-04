package br.com.chapecosolucoes.trafegusweb.client.ws
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
    import br.com.chapecosolucoes.trafegusweb.client.components.wait.Wait;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.model.UsuarioLogado;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    
    import flash.events.Event;
    import flash.net.URLLoader;
    import flash.net.URLRequest;
    
    import mx.charts.chartClasses.InstanceCache;
    import mx.controls.Alert;
    import mx.events.FlexEvent;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    import mx.rpc.soap.mxml.Operation;
    import mx.rpc.soap.mxml.WebService;
    import mx.utils.ObjectUtil;
    
    import org.osmf.layout.AbsoluteLayoutFacet;

    public class TrafegusWS
    {
        private static var instance:TrafegusWS = null;

        private var webservice:WebService = null;

        public function TrafegusWS(singletonForce:SingletonForcer)
        {
            if (singletonForce == null)
            {
                throw new Error("Utilize o metodo getIntance()");
            }
            this.webservice = new WebService();
            this.webservice.wsdl = UsuarioLogado.getInstance().wsdl;
            this.webservice.loadWSDL();
        }

        public static function getIntance():TrafegusWS
        {
            if (instance == null)
            {
                instance = new TrafegusWS(new SingletonForcer());
            }
            return instance;
        }

        private function createOperation(operationName:String, result:Function = null):Operation
        {
            var operation:Operation = Operation(this.webservice.getOperation(operationName));
            if (operation == null)
            {
                operation = new Operation(this.webservice, operationName);
                operation.showBusyCursor = true;
            }
            if (result != null)
            {
                operation.addEventListener(ResultEvent.RESULT, result);
            }
            operation.addEventListener(FaultEvent.FAULT, this.onFaultHandler);
            operation.addEventListener(ResultEvent.RESULT, this.onResultHander);
            Wait.getInstance().Show();
            return operation;
        }

        private function onFaultHandler(e:FaultEvent):void
        {
            Wait.getInstance().Close();
            MessageBox.erro(e.fault.message);
        }

        private function onResultHander(e:ResultEvent):void
        {
            Wait.getInstance().Close();
        }

        public function solicitaAcesso(solicitaAcessoHandler:Function, usuario:String, senha:String):void
        {
            var operation:Operation = createOperation("solicitaAcesso", solicitaAcessoHandler);
            operation.send(UsuarioLogado.getInstance().IdSessao,usuario, senha);
        }

        public function solicitaListaVeiculos(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaVeiculos", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaDadosGrid(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGrid", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO, offset:int):void
        {
            var operation:Operation = createOperation("SolicitaHistoricoPosicoes", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, params.vehiclePlate, offset, false);
        }

        public function solicitaDadosMotorista(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosMotorista", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, params);
        }

        public function solicitaDadosVeiculo(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosVeiculo", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,params);
        }

        public function solicitaDadosGridEmViagem(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGridEmViagem", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaMotoristas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaMotoristas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaRotas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaRotas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaEmbarcadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaEmbarcadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTransportadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTransportadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,offset);
        }

        public function solicitaDadosEmbarcador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosEmbarcador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,param);
        }

        public function solicitaDadosTransportador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosTransportador", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,param);
        }

        public function solicitaListaLocais(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaLocais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTipoTransporte(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTipoTransporte", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,offset);
        }

        public function solicitaDadosLocal(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosLocal", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,param);
        }

        public function solicitaListaCarretasDisponiveis(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaListaCarretasDisponiveis", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaListaPGR(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,offset);
        }

        public function solicitaDadosPGR(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,param);
        }

        public function solicitaListaViagemPai(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaViagemPai", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTerminais(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaListaTerminais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().solicitacaoMonitoramentoVO.placaTruc);
        }

        public function solicitaTotalDadosGrid(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGrid", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaLocais(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaLocais", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaEmbarcadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaEmbarcadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaMotoristas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaMotoristas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaPGR(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaPGR", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaTotalListaRotas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaRotas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaTipoTransporte(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTipoTransporte", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaTotalListaTransportadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTransportadores", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao);
        }

        public function solicitaTotalListaVeiculos(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaVeiculos", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaViagemPai(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaViagemPai", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO):void
        {
            var operation:Operation = createOperation("solicitaTotalHistoricoPosicoes", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, params.vehiclePlate);
        }

        public function solicitaDadosTerminalDefeituoso(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaDadosTerminalDefeituoso", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codTerminais);
        }

        public function solicitaTotalDadosGridEmViagem(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGridEmViagem", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function salvarPosicaoTelas(handler:Function):void
        {
            var operation:Operation = createOperation("salvarPosicaoTelas", handler);
            with (UsuarioLogado.getInstance())
            {
                operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codUsuario, gridVeiculosX, gridVeiculosY, gridVeiculosPercentWidth, gridVeiculosPercentWidth, mapaGoogleX, mapaGoogleY, mapaGooglePercentWidth, mapaGooglePercentHeight, gridDetalheX, gridDetalheY, gridDetalhePercentWidth, gridDetalhePercentHeight);
            }
        }

        public function solicitaClassesReferencias(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaClassesReferencias", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa);
        }

        public function solicitaRefencias(handler:Function, codClasseReferencia:String):void
        {
            var operation:Operation = createOperation("solicitaRefencias", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codEmpresa, codClasseReferencia);
        }

        public function lerPosicaoTelas(handler:Function):void
        {
            var operation:Operation = createOperation("lerPosicaoTelas", handler);
            operation.send(UsuarioLogado.getInstance().IdSessao,MainModel.getInstance().codUsuario);
        }
		public function logout(handler:Function):void
		{
			var operation:Operation = createOperation("logout", handler);
			operation.send(UsuarioLogado.getInstance().IdSessao);
		}
    }
}

class SingletonForcer
{
}