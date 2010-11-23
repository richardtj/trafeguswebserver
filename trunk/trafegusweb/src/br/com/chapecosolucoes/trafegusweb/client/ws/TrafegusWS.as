package br.com.chapecosolucoes.trafegusweb.client.ws
{
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

		private function createOperation(operationName:String):Operation
		{
			var operation:Operation = Operation(this.webservice.getOperation(operationName));
			if (operation == null)
			{
				operation = new Operation(this.webservice, operationName);
			}
			operation.addEventListener(FaultEvent.FAULT, onFaultHandler);
			return operation;
		}

		private function onFaultHandler(e:FaultEvent):void
		{
			Alert.show(e.fault.message);
		}

		public function solicitaAcesso(solicitaAcessoHandler:Function,usuario:String, senha:String):void
		{
			var operation:Operation = createOperation("solicitaAcesso");
			operation.addEventListener(ResultEvent.RESULT, solicitaAcessoHandler);
			operation.showBusyCursor = true;
			operation.send(usuario, senha);
		}
		public function solicitaListaVeiculos(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaListaVeiculos");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.showBusyCursor = true;
			operation.send(MainModel.getInstance().codEmpresa);
		}
		
		public function solicitaDadosGrid(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaDadosGrid");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.showBusyCursor = true;
			operation.send(MainModel.getInstance().codEmpresa);
		}
		
		public function solicitaHistoricoPosicoes(handler:Function,params:PosicaoVeiculoVO):void{
			var operation:Operation = createOperation("SolicitaHistoricoPosicoes");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.showBusyCursor = true;
			operation.send(MainModel.getInstance().codEmpresa,params.vehiclePlate,0,30,false);
		}
		
		public function solicitaDadosMotorista(handler:Function,params:String):void
		{
			var operation:Operation = createOperation("solicitaDadosMotorista");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.showBusyCursor = true;
			operation.send(MainModel.getInstance().codEmpresa,params);
		}
		
		public function solicitaDadosVeiculo(handler:Function,params:String):void
		{
			var operation:Operation = createOperation("solicitaDadosVeiculo");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.showBusyCursor = true;
			operation.send(params);
		}
	}
}

class SingletonForcer
{
}