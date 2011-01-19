package br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import mx.containers.Form;
	import mx.containers.FormItem;
	import mx.controls.TextInput;

	public class AdvancedSearchReferenciasImplController extends AdvancedSearchController
	{
		public function AdvancedSearchReferenciasImplController()
		{
			super();
		}
		override public function search():void
		{
			var formItemReferencia:FormItem = FormItem(Form(this.view.form).getChildByName("formItemReferencia"));
			var formItemGrupo:FormItem = FormItem(Form(this.view.form).getChildByName("formItemGrupo"));
			var referenciaVO:ReferenciaVO = new ReferenciaVO();
			referenciaVO.refeDescricao = TextInput(formItemReferencia.getChildByName("textInputReferencia")).text;
			referenciaVO.descricao = TextInput(formItemGrupo.getChildByName("textInputGrupo")).text;
			var event:AdvancedSearchEvent = new AdvancedSearchEvent(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,referenciaVO);
			this.view.dispatchEvent(event);
			this.closeHandler();
		}
	}
}