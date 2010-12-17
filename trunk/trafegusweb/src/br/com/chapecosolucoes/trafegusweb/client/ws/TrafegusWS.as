package br.com.chapecosolucoes.trafegusweb.client.ws
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
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
            operation.addEventListener(FaultEvent.FAULT, onFaultHandler);
            if (result != null)
            {
                operation.addEventListener(ResultEvent.RESULT, result);
            }
            return operation;
        }

        private function onFaultHandler(e:FaultEvent):void
        {
            MessageBox.erro(e.fault.message);
        }

        public function solicitaAcesso(solicitaAcessoHandler:Function, usuario:String, senha:String):void
        {
            var operation:Operation = createOperation("solicitaAcesso", solicitaAcessoHandler);
            operation.send(usuario, senha);
        }

        public function solicitaListaVeiculos(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaVeiculos", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaDadosGrid(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGrid", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO, offset:int):void
        {
            var operation:Operation = createOperation("SolicitaHistoricoPosicoes", handler);
            operation.send(MainModel.getInstance().codEmpresa, params.vehiclePlate, offset, false);
        }

        public function solicitaDadosMotorista(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosMotorista", handler);
            operation.send(MainModel.getInstance().codEmpresa, params);
        }

        public function solicitaDadosVeiculo(handler:Function, params:String):void
        {
            var operation:Operation = createOperation("solicitaDadosVeiculo", handler);
            operation.send(params);
        }

        public function solicitaDadosGridEmViagem(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaDadosGridEmViagem", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaMotoristas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaMotoristas", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaRotas(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaRotas", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaEmbarcadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaEmbarcadores", handler);
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTransportadores(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTransportadores", handler);
            operation.send(offset);
        }

        public function solicitaDadosEmbarcador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosEmbarcador", handler);
            operation.send(param);
        }

        public function solicitaDadosTransportador(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosTransportador", handler);
            operation.send(param);
        }

        public function solicitaListaLocais(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaLocais");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTipoTransporte(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaTipoTransporte");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(offset);
        }

        public function solicitaDadosLocal(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosLocal");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(param);
        }

        public function solicitaListaCarretasDisponiveis(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaListaCarretasDisponiveis");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaListaPGR(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaPGR");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(offset);
        }

        public function solicitaDadosPGR(handler:Function, param:String):void
        {
            var operation:Operation = createOperation("solicitaDadosPGR");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(param);
        }

        public function solicitaListaViagemPai(handler:Function, offset:int):void
        {
            var operation:Operation = createOperation("solicitaListaViagemPai");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa, offset);
        }

        public function solicitaListaTerminais(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaListaTerminais");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().solicitacaoMonitoramentoVO.placaTruc);
        }

        public function solicitaTotalDadosGrid(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGrid");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaLocais(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaLocais");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaEmbarcadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaEmbarcadores");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaMotoristas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaMotoristas");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaPGR(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaPGR");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send();
        }

        public function solicitaTotalListaRotas(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaRotas");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaTipoTransporte(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTipoTransporte");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send();
        }

        public function solicitaTotalListaTransportadores(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaTransportadores");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send();
        }

        public function solicitaTotalListaVeiculos(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaVeiculos");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalListaViagemPai(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalListaViagemPai");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function solicitaTotalHistoricoPosicoes(handler:Function, params:PosicaoVeiculoVO):void
        {
            var operation:Operation = createOperation("solicitaTotalHistoricoPosicoes");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa, params.vehiclePlate);
        }

        public function solicitaDadosTerminalDefeituoso(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaDadosTerminalDefeituoso");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codTerminais);
        }

        public function solicitaTotalDadosGridEmViagem(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaTotalDadosGridEmViagem", handler);
            operation.send(MainModel.getInstance().codEmpresa);
        }

        public function salvarPosicaoTelas(handler:Function):void
        {
            var operation:Operation = createOperation("salvarPosicaoTelas", handler);
            with (UsuarioLogado.getInstance())
            {
                operation.send("salvarPosicaoTelas", MainModel.getInstance().codUsuario, gridVeiculosX, gridVeiculosY, gridVeiculosPercentWidth, gridVeiculosPercentWidth, mapaGoogleX, mapaGoogleY, mapaGooglePercentWidth, mapaGooglePercentHeight, gridDetalheX, gridDetalheY, gridDetalhePercentWidth, gridDetalhePercentHeight);
            }
        }

        public function solicitaClassesReferencias(handler:Function):void
        {
            var operation:Operation = createOperation("solicitaClassesReferencias");
            operation.addEventListener(ResultEvent.RESULT, handler);
            operation.showBusyCursor = true;
            operation.send(MainModel.getInstance().codEmpresa);
        }
    }
}

class SingletonForcer
{
}