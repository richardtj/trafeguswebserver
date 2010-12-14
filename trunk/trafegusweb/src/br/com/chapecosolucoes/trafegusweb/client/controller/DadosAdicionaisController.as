package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DadosAdicionaisView;
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
			TrafegusWS.getIntance().solicitaListaTerminais(solicitaListaTerminaisResultHandler);
		}
		private function solicitaListaTerminaisResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().terminaisArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var terminal:TerminalVO = new TerminalVO();
				terminal.setTerminalVO(obj);
				MainModel.getInstance().terminaisArray.addItem(terminal);
			}
			this.solicitaDadosTerminalDefeituoso();
		}
		public function solicitaDadosTerminalDefeituoso():void
		{
			for each(var terminal:TerminalVO in MainModel.getInstance().terminaisArray)
			{
				Alert.show(terminal.codigo);
			}
		}
	}
}