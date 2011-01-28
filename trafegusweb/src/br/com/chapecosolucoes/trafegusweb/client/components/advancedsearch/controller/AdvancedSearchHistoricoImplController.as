package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.datafieldpt.DataFieldPT;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.vo.AdvancedSearchHistoricoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import mx.containers.Form;
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearcHistoricoImplController extends AdvancedSearchController
	{
		public function AdvancedSearcHistoricoImplController()
		{
			super();
		}
		override public function search():void
		{
			var formItemDataInicial:FormItem = FormItem(Form(this.view.form).getChildByName("formItemDataInicial"));
			var formItemDataFinal:FormItem = FormItem(Form(this.view.form).getChildByName("formItemDataFinal"));
			var formItemGPSDescSis:FormItem = FormItem(Form(this.view.form).getChildByName("formItemGPSDescSis"));
			
			var dfDataInicial:DataFieldPT = DataFieldPT(Form(formItemDataInicial).getChildByName("dfDataInicial"));
			var dfDataFinal:DataFieldPT = DataFieldPT(Form(formItemDataFinal).getChildByName("dfDataFinal"));
			var textInputGPSDescSis:TextInput = TextInput(Form(formItemGPSDescSis).getChildByName("textInputGPSDescSis"));
			
			var historico:AdvancedSearchHistoricoVO = new AdvancedSearchHistoricoVO();
			historico.gpsDescSis = textInputGPSDescSis.text;
			historico.dataInicial = dfDataInicial.value;
			historico.dataFinal = dfDataFinal.value;
			
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,historico);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}