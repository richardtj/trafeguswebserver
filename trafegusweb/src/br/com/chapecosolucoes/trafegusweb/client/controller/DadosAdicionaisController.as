package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.DadosAdicionaisView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.rpc.events.ResultEvent;

	public class DadosAdicionaisController
	{
		public function DadosAdicionaisController()
		{
		}
		public var view:DadosAdicionaisView;
		public function solicitaListaTerminais():void
		{
			TrafegusWS.getIntance().solicitaListaTerminais(solicitaListaTerminaisResultHandler,MainModel.getInstance().smVO.veiculoPrincipal.vehiclePlate);
		}
		private function solicitaListaTerminaisResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalVO = new TerminalVO();
				terminal.setTerminalVO(obj);
				MainModel.getInstance().smVO.terminaisArray.addItem(terminal);
			}
			this.solicitaDadosTerminalDefeituoso();
		}
		public function solicitaDadosTerminalDefeituoso():void
		{
			//MainModel.getInstance().smVO.codTerminais = "";
			for each(var terminal:TerminalVO in MainModel.getInstance().smVO.terminaisArray)
			{
				if(MainModel.getInstance().smVO.codTerminais != "")
				{
					MainModel.getInstance().smVO.codTerminais += ",";
				}
				MainModel.getInstance().smVO.codTerminais += terminal.codigo;
			}
			TrafegusWS.getIntance().solicitaDadosTerminalDefeituoso(solicitaDadosTerminalDefeituosoResultHandler);
		}
		private function solicitaDadosTerminalDefeituosoResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().smVO.terminaisDefeituososArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalDefeituosoVO = new TerminalDefeituosoVO();
				terminal.setTerminalDefeituosoVO(obj);
				MainModel.getInstance().smVO.terminaisDefeituososArray.addItem(terminal);
			}
		}
	}
}