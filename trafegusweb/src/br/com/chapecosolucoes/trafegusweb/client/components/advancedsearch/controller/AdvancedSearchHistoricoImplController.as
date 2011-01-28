package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
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
			var historico:HistoricoPosicoesVeiculoVO = new HistoricoPosicoesVeiculoVO();
			historico.= TextInput(formItemReferencia.getChildByName("textInputReferencia")).text;
			referenciaVO.descricao = TextInput(formItemGrupo.getChildByName("textInputGrupo")).text;
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,referenciaVO);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}