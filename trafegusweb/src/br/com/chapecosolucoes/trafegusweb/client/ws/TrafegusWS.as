package br.com.chapecosolucoes.trafegusweb.client.ws
{
	import br.com.chapecosolucoes.trafegusweb.client.config.Config;
	
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
			this.webservice.wsdl = "http://localhost:8080/trafegusws/TrafegusWS?wsdl";
			this.webservice.loadWSDL();
		}
		
		protected function preinitializeHandler(event:FlexEvent):void
		{
			var req:URLRequest = new URLRequest("config.xml");
			var loader:URLLoader = new URLLoader(req);
			loader.addEventListener(Event.COMPLETE, xmlConfigLoaderComplete);
			
			function xmlConfigLoaderComplete(e:Event):void
			{
				Config.getInstance().wsdl = XML(loader.data).wsdl;
			}
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

		public function solicitaAcesso(usuario:String, senha:String):void
		{
			var operation:Operation = createOperation("solicitaAcesso");
			operation.addEventListener(ResultEvent.RESULT, solicitaAcessoHandler);
			operation.send(usuario, senha);
			
			function solicitaAcessoHandler(evt:ResultEvent):void {
				Alert.show(ObjectUtil.toString(evt.result));
			}
		}
		public function solicitaListaVeiculos(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaListaVeiculos");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.send(1453);
		}
		
		public function solicitaDadosGrid(handler:Function):void
		{
			var operation:Operation = createOperation("solicitaDadosGrid");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.send(1453);
		}
		
		public function solicitaHistoricoPosicoes(handler:Function):void{
			var operation:Operation = createOperation("SolicitaHistoricoPosicoes");
			operation.addEventListener(ResultEvent.RESULT, handler);
			operation.send(1453,"AHU7915",0,30,false);
		}
	}
}

class SingletonForcer
{
}