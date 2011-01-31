package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.datafieldpt.DataFieldPT;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
<<<<<<< .mine
	import br.com.chapecosolucoes.trafegusweb.client.vo.AdvancedSearcHistoricoVO;
=======
	import br.com.chapecosolucoes.trafegusweb.client.vo.AdvancedSearchHistoricoVO;
>>>>>>> .r338
	import br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import mx.containers.Form;
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearchHistoricoImplController extends AdvancedSearchController
	{
		public function AdvancedSearchHistoricoImplController()
		{
			super();
		}
		override public function search():void
		{
			var formItemDataInicial:FormItem = FormItem(Form(this.view.form).getChildByName("formItemDataInicial"));
			var dfDataInicial:DataFieldPT = formItemDataInicial.getChildByName("dfDataInicial");

			var formItemDataFinal:FormItem = FormItem(Form(this.view.form).getChildByName("formItemDataFinal"));
<<<<<<< .mine
			var dfDataFinal:DataFieldPT = formItemDataFinal.getChildByName("dfDataFinal");

			var formItemDescricao:FormItem(Form(this.view.form).getChildByName("formItemDescricao"));
			var txtDescricao:TextInput = formItemDescricao.getChildIndex("txtDescricao");
			var historico:AdvancedSearcHistoricoVO = new AdvancedSearcHistoricoVO();
			
			historico.dataInicial = dfDataInicial.text;
			historico.dataFinal = dfDataFinal.text;
			historico.descricao = txtDescricao.text;
			
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,historico);
=======
			var formItemGPSDescSis:FormItem = FormItem(Form(this.view.form).getChildByName("formItemGPSDescSis"));
			
			var dfDataInicial:DataFieldPT = DataFieldPT(FormItem(formItemDataInicial).getChildByName("dfDataInicial"));
			var dfDataFinal:DataFieldPT = DataFieldPT(FormItem(formItemDataFinal).getChildByName("dfDataFinal"));
			var textInputGPSDescSis:TextInput = TextInput(FormItem(formItemGPSDescSis).getChildByName("textInputGPSDescSis"));
			
			var historico:AdvancedSearchHistoricoVO = new AdvancedSearchHistoricoVO();
			historico.gpsDescSis = textInputGPSDescSis.text;
			historico.dataInicial = dfDataInicial.text;
			historico.dataFinal = dfDataFinal.text;
			
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,historico);
>>>>>>> .r338
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}