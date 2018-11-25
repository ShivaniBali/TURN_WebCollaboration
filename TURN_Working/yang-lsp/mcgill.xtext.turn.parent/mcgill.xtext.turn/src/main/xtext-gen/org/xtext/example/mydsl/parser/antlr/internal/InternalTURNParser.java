package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.TURNGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTURNParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'urnModel'", "'showAsMeansEnd'", "'metadata'", "'{'", "'}'", "'description'", "'author'", "'created'", "'modified'", "'version'", "'urnVersion'", "'concern'", "':'", "','", "'#'", "'['", "']'", "'link'", "'type'", "'-->'", "'='", "'actor'", "'importance'", "'unit'", "'contributesTo'", "'correlated'", "'with'", "'decomposes'", "'dependsOn'", "'strategiesGroup'", "'strategy'", "'includes'", "'exceeding'", "'evaluation'", "'convertedWith'", "'real'", "'linearConversion'", "'target'", "'threshold'", "'worst'", "'mappingConversion'", "'contributionContextGroup'", "'contributionContext'", "'-'", "'+'", "'singleton'", "'map'", "'start'", "'catches'", "'abort'", "'failure'", "';'", "'in'", "'->'", "'X'", "'join'", "'synch'", "'sync'", "'|'", "'wait'", "'timer'", "'timeout'", "'trigger'", "'fail'", "'end'", "'.'", "'or'", "'[else]'", "'and'", "'*'", "'stub'", "'('", "')'", "'out'", "'replication'", "'protected'", "'..'", "'[['", "']]'", "'@'", "'!'", "'%'", "'&'", "'denied'", "'weaklyDenied'", "'weaklySatisfied'", "'satisfied'", "'conflict'", "'unknown'", "'none'", "'softgoal'", "'goal'", "'task'", "'resource'", "'belief'", "'indicator'", "'undefined'", "'make'", "'help'", "'somePositive'", "'someNegative'", "'hurt'", "'break'", "'high'", "'medium'", "'low'", "'xor'", "'persistent'", "'transient'", "'synchronizing'", "'blocking'", "'team'", "'object'", "'process'", "'agent'", "'parent'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalTURNParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTURNParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTURNParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTURN.g"; }



     	private TURNGrammarAccess grammarAccess;

        public InternalTURNParser(TokenStream input, TURNGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "URNspec";
       	}

       	@Override
       	protected TURNGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleURNspec"
    // InternalTURN.g:65:1: entryRuleURNspec returns [EObject current=null] : iv_ruleURNspec= ruleURNspec EOF ;
    public final EObject entryRuleURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNspec = null;


        try {
            // InternalTURN.g:65:48: (iv_ruleURNspec= ruleURNspec EOF )
            // InternalTURN.g:66:2: iv_ruleURNspec= ruleURNspec EOF
            {
             newCompositeNode(grammarAccess.getURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNspec=ruleURNspec();

            state._fsp--;

             current =iv_ruleURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNspec"


    // $ANTLR start "ruleURNspec"
    // InternalTURN.g:72:1: ruleURNspec returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_showAsMeansEnd_9_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_info_3_0 = null;

        EObject lv_stratGroups_4_0 = null;

        EObject lv_strategies_5_0 = null;

        EObject lv_indConversions_6_0 = null;

        EObject lv_contribContextGroups_7_0 = null;

        EObject lv_contribContexts_8_0 = null;

        EObject lv_ucmMaps_10_0 = null;

        EObject lv_actors_11_0 = null;

        EObject lv_concerns_12_0 = null;

        EObject lv_urnlinks_13_0 = null;

        EObject lv_metadata_16_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalTURN.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalTURN.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) ) )
            // InternalTURN.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalTURN.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?) )
            // InternalTURN.g:81:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			
            // InternalTURN.g:84:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?)
            // InternalTURN.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+ {...}?
            {
            // InternalTURN.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=13;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // InternalTURN.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    {
            	    // InternalTURN.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    // InternalTURN.g:87:4: {...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalTURN.g:87:101: ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    // InternalTURN.g:88:5: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalTURN.g:91:8: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    // InternalTURN.g:91:9: {...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTURN.g:91:18: (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    // InternalTURN.g:91:19: otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    {
            	    otherlv_1=(Token)match(input,11,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getURNspecAccess().getUrnModelKeyword_0_0());
            	    							
            	    // InternalTURN.g:95:8: ( (lv_name_2_0= ruleQualifiedName ) )
            	    // InternalTURN.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    {
            	    // InternalTURN.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    // InternalTURN.g:97:10: lv_name_2_0= ruleQualifiedName
            	    {

            	    										newCompositeNode(grammarAccess.getURNspecAccess().getNameQualifiedNameParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleQualifiedName();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.xtext.example.mydsl.TURN.QualifiedName");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalTURN.g:114:8: ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==14) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalTURN.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            {
            	            // InternalTURN.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            // InternalTURN.g:116:10: lv_info_3_0= ruleConcreteURNspec
            	            {

            	            										newCompositeNode(grammarAccess.getURNspecAccess().getInfoConcreteURNspecParserRuleCall_0_2_0());
            	            									
            	            pushFollow(FOLLOW_5);
            	            lv_info_3_0=ruleConcreteURNspec();

            	            state._fsp--;


            	            										if (current==null) {
            	            											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	            										}
            	            										set(
            	            											current,
            	            											"info",
            	            											lv_info_3_0,
            	            											"org.xtext.example.mydsl.TURN.ConcreteURNspec");
            	            										afterParserOrEnumRuleCall();
            	            									

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTURN.g:139:3: ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) )
            	    {
            	    // InternalTURN.g:139:3: ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) )
            	    // InternalTURN.g:140:4: {...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalTURN.g:140:101: ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ )
            	    // InternalTURN.g:141:5: ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalTURN.g:144:8: ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==40) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalTURN.g:144:9: {...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:144:18: ( (lv_stratGroups_4_0= ruleStrategiesGroup ) )
            	    	    // InternalTURN.g:144:19: (lv_stratGroups_4_0= ruleStrategiesGroup )
            	    	    {
            	    	    // InternalTURN.g:144:19: (lv_stratGroups_4_0= ruleStrategiesGroup )
            	    	    // InternalTURN.g:145:9: lv_stratGroups_4_0= ruleStrategiesGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStratGroupsStrategiesGroupParserRuleCall_1_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_stratGroups_4_0=ruleStrategiesGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"stratGroups",
            	    	    										lv_stratGroups_4_0,
            	    	    										"org.xtext.example.mydsl.TURN.StrategiesGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTURN.g:167:3: ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) )
            	    {
            	    // InternalTURN.g:167:3: ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) )
            	    // InternalTURN.g:168:4: {...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalTURN.g:168:101: ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ )
            	    // InternalTURN.g:169:5: ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalTURN.g:172:8: ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==41) ) {
            	            int LA3_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt3=1;
            	            }


            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalTURN.g:172:9: {...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:172:18: ( (lv_strategies_5_0= ruleEvaluationStrategy ) )
            	    	    // InternalTURN.g:172:19: (lv_strategies_5_0= ruleEvaluationStrategy )
            	    	    {
            	    	    // InternalTURN.g:172:19: (lv_strategies_5_0= ruleEvaluationStrategy )
            	    	    // InternalTURN.g:173:9: lv_strategies_5_0= ruleEvaluationStrategy
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStrategiesEvaluationStrategyParserRuleCall_2_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_strategies_5_0=ruleEvaluationStrategy();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"strategies",
            	    	    										lv_strategies_5_0,
            	    	    										"org.xtext.example.mydsl.TURN.EvaluationStrategy");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTURN.g:195:3: ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) )
            	    {
            	    // InternalTURN.g:195:3: ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) )
            	    // InternalTURN.g:196:4: {...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalTURN.g:196:101: ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ )
            	    // InternalTURN.g:197:5: ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalTURN.g:200:8: ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==47) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }
            	        else if ( (LA4_0==51) ) {
            	            int LA4_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalTURN.g:200:9: {...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:200:18: ( (lv_indConversions_6_0= ruleIndicatorConversion ) )
            	    	    // InternalTURN.g:200:19: (lv_indConversions_6_0= ruleIndicatorConversion )
            	    	    {
            	    	    // InternalTURN.g:200:19: (lv_indConversions_6_0= ruleIndicatorConversion )
            	    	    // InternalTURN.g:201:9: lv_indConversions_6_0= ruleIndicatorConversion
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getIndConversionsIndicatorConversionParserRuleCall_3_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_indConversions_6_0=ruleIndicatorConversion();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"indConversions",
            	    	    										lv_indConversions_6_0,
            	    	    										"org.xtext.example.mydsl.TURN.IndicatorConversion");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTURN.g:223:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) )
            	    {
            	    // InternalTURN.g:223:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) )
            	    // InternalTURN.g:224:4: {...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalTURN.g:224:101: ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ )
            	    // InternalTURN.g:225:5: ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalTURN.g:228:8: ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==52) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalTURN.g:228:9: {...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:228:18: ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) )
            	    	    // InternalTURN.g:228:19: (lv_contribContextGroups_7_0= ruleContributionContextGroup )
            	    	    {
            	    	    // InternalTURN.g:228:19: (lv_contribContextGroups_7_0= ruleContributionContextGroup )
            	    	    // InternalTURN.g:229:9: lv_contribContextGroups_7_0= ruleContributionContextGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextGroupsContributionContextGroupParserRuleCall_4_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_contribContextGroups_7_0=ruleContributionContextGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContextGroups",
            	    	    										lv_contribContextGroups_7_0,
            	    	    										"org.xtext.example.mydsl.TURN.ContributionContextGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTURN.g:251:3: ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) )
            	    {
            	    // InternalTURN.g:251:3: ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) )
            	    // InternalTURN.g:252:4: {...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalTURN.g:252:101: ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ )
            	    // InternalTURN.g:253:5: ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalTURN.g:256:8: ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==53) ) {
            	            int LA6_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt6=1;
            	            }


            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalTURN.g:256:9: {...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:256:18: ( (lv_contribContexts_8_0= ruleContributionContext ) )
            	    	    // InternalTURN.g:256:19: (lv_contribContexts_8_0= ruleContributionContext )
            	    	    {
            	    	    // InternalTURN.g:256:19: (lv_contribContexts_8_0= ruleContributionContext )
            	    	    // InternalTURN.g:257:9: lv_contribContexts_8_0= ruleContributionContext
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextsContributionContextParserRuleCall_5_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_contribContexts_8_0=ruleContributionContext();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContexts",
            	    	    										lv_contribContexts_8_0,
            	    	    										"org.xtext.example.mydsl.TURN.ContributionContext");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTURN.g:279:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) )
            	    {
            	    // InternalTURN.g:279:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) )
            	    // InternalTURN.g:280:4: {...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6)");
            	    }
            	    // InternalTURN.g:280:101: ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) )
            	    // InternalTURN.g:281:5: ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6);
            	    				
            	    // InternalTURN.g:284:8: ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) )
            	    // InternalTURN.g:284:9: {...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTURN.g:284:18: ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) )
            	    // InternalTURN.g:284:19: (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' )
            	    {
            	    // InternalTURN.g:284:19: (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' )
            	    // InternalTURN.g:285:9: lv_showAsMeansEnd_9_0= 'showAsMeansEnd'
            	    {
            	    lv_showAsMeansEnd_9_0=(Token)match(input,12,FOLLOW_5); 

            	    									newLeafNode(lv_showAsMeansEnd_9_0, grammarAccess.getURNspecAccess().getShowAsMeansEndShowAsMeansEndKeyword_6_0());
            	    								

            	    									if (current==null) {
            	    										current = createModelElement(grammarAccess.getURNspecRule());
            	    									}
            	    									setWithLastConsumed(current, "showAsMeansEnd", true, "showAsMeansEnd");
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTURN.g:302:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) )
            	    {
            	    // InternalTURN.g:302:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) )
            	    // InternalTURN.g:303:4: {...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7)");
            	    }
            	    // InternalTURN.g:303:101: ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ )
            	    // InternalTURN.g:304:5: ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7);
            	    				
            	    // InternalTURN.g:307:8: ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==56) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt7=1;
            	            }


            	        }
            	        else if ( (LA7_0==57) ) {
            	            int LA7_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalTURN.g:307:9: {...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:307:18: ( (lv_ucmMaps_10_0= ruleUCMmap ) )
            	    	    // InternalTURN.g:307:19: (lv_ucmMaps_10_0= ruleUCMmap )
            	    	    {
            	    	    // InternalTURN.g:307:19: (lv_ucmMaps_10_0= ruleUCMmap )
            	    	    // InternalTURN.g:308:9: lv_ucmMaps_10_0= ruleUCMmap
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUcmMapsUCMmapParserRuleCall_7_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_ucmMaps_10_0=ruleUCMmap();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"ucmMaps",
            	    	    										lv_ucmMaps_10_0,
            	    	    										"org.xtext.example.mydsl.TURN.UCMmap");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTURN.g:330:3: ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) )
            	    {
            	    // InternalTURN.g:330:3: ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) )
            	    // InternalTURN.g:331:4: {...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8)");
            	    }
            	    // InternalTURN.g:331:101: ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ )
            	    // InternalTURN.g:332:5: ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8);
            	    				
            	    // InternalTURN.g:335:8: ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==32) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalTURN.g:335:9: {...}? => ( (lv_actors_11_0= ruleActor ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:335:18: ( (lv_actors_11_0= ruleActor ) )
            	    	    // InternalTURN.g:335:19: (lv_actors_11_0= ruleActor )
            	    	    {
            	    	    // InternalTURN.g:335:19: (lv_actors_11_0= ruleActor )
            	    	    // InternalTURN.g:336:9: lv_actors_11_0= ruleActor
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getActorsActorParserRuleCall_8_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_actors_11_0=ruleActor();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"actors",
            	    	    										lv_actors_11_0,
            	    	    										"org.xtext.example.mydsl.TURN.Actor");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalTURN.g:358:3: ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) )
            	    {
            	    // InternalTURN.g:358:3: ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) )
            	    // InternalTURN.g:359:4: {...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalTURN.g:359:101: ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ )
            	    // InternalTURN.g:360:5: ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalTURN.g:363:8: ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalTURN.g:363:9: {...}? => ( (lv_concerns_12_0= ruleConcern ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:363:18: ( (lv_concerns_12_0= ruleConcern ) )
            	    	    // InternalTURN.g:363:19: (lv_concerns_12_0= ruleConcern )
            	    	    {
            	    	    // InternalTURN.g:363:19: (lv_concerns_12_0= ruleConcern )
            	    	    // InternalTURN.g:364:9: lv_concerns_12_0= ruleConcern
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getConcernsConcernParserRuleCall_9_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_concerns_12_0=ruleConcern();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"concerns",
            	    	    										lv_concerns_12_0,
            	    	    										"org.xtext.example.mydsl.TURN.Concern");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalTURN.g:386:3: ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) )
            	    {
            	    // InternalTURN.g:386:3: ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) )
            	    // InternalTURN.g:387:4: {...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalTURN.g:387:102: ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ )
            	    // InternalTURN.g:388:5: ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalTURN.g:391:8: ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==28) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalTURN.g:391:9: {...}? => ( (lv_urnlinks_13_0= ruleURNlink ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTURN.g:391:18: ( (lv_urnlinks_13_0= ruleURNlink ) )
            	    	    // InternalTURN.g:391:19: (lv_urnlinks_13_0= ruleURNlink )
            	    	    {
            	    	    // InternalTURN.g:391:19: (lv_urnlinks_13_0= ruleURNlink )
            	    	    // InternalTURN.g:392:9: lv_urnlinks_13_0= ruleURNlink
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUrnlinksURNlinkParserRuleCall_10_0());
            	    	    								
            	    	    pushFollow(FOLLOW_5);
            	    	    lv_urnlinks_13_0=ruleURNlink();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"urnlinks",
            	    	    										lv_urnlinks_13_0,
            	    	    										"org.xtext.example.mydsl.TURN.URNlink");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalTURN.g:414:3: ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) )
            	    {
            	    // InternalTURN.g:414:3: ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) )
            	    // InternalTURN.g:415:4: {...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11)");
            	    }
            	    // InternalTURN.g:415:102: ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) )
            	    // InternalTURN.g:416:5: ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11);
            	    				
            	    // InternalTURN.g:419:8: ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) )
            	    // InternalTURN.g:419:9: {...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTURN.g:419:18: (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' )
            	    // InternalTURN.g:419:19: otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}'
            	    {
            	    otherlv_14=(Token)match(input,13,FOLLOW_6); 

            	    								newLeafNode(otherlv_14, grammarAccess.getURNspecAccess().getMetadataKeyword_11_0());
            	    							
            	    otherlv_15=(Token)match(input,14,FOLLOW_7); 

            	    								newLeafNode(otherlv_15, grammarAccess.getURNspecAccess().getLeftCurlyBracketKeyword_11_1());
            	    							
            	    // InternalTURN.g:427:8: ( (lv_metadata_16_0= ruleMetadata ) )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==RULE_ID) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalTURN.g:428:9: (lv_metadata_16_0= ruleMetadata )
            	    	    {
            	    	    // InternalTURN.g:428:9: (lv_metadata_16_0= ruleMetadata )
            	    	    // InternalTURN.g:429:10: lv_metadata_16_0= ruleMetadata
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getURNspecAccess().getMetadataMetadataParserRuleCall_11_2_0());
            	    	    									
            	    	    pushFollow(FOLLOW_7);
            	    	    lv_metadata_16_0=ruleMetadata();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"metadata",
            	    	    											lv_metadata_16_0,
            	    	    											"org.xtext.example.mydsl.TURN.Metadata");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);

            	    otherlv_17=(Token)match(input,15,FOLLOW_5); 

            	    								newLeafNode(otherlv_17, grammarAccess.getURNspecAccess().getRightCurlyBracketKeyword_11_3());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNspec"


    // $ANTLR start "entryRuleConcreteURNspec"
    // InternalTURN.g:467:1: entryRuleConcreteURNspec returns [EObject current=null] : iv_ruleConcreteURNspec= ruleConcreteURNspec EOF ;
    public final EObject entryRuleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteURNspec = null;


        try {
            // InternalTURN.g:467:56: (iv_ruleConcreteURNspec= ruleConcreteURNspec EOF )
            // InternalTURN.g:468:2: iv_ruleConcreteURNspec= ruleConcreteURNspec EOF
            {
             newCompositeNode(grammarAccess.getConcreteURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteURNspec=ruleConcreteURNspec();

            state._fsp--;

             current =iv_ruleConcreteURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteURNspec"


    // $ANTLR start "ruleConcreteURNspec"
    // InternalTURN.g:474:1: ruleConcreteURNspec returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) ;
    public final EObject ruleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_description_2_0=null;
        Token otherlv_3=null;
        Token lv_author_4_0=null;
        Token otherlv_5=null;
        Token lv_created_6_0=null;
        Token otherlv_7=null;
        Token lv_modified_8_0=null;
        Token otherlv_9=null;
        Token lv_specVersion_10_0=null;
        Token otherlv_11=null;
        Token lv_urnVersion_12_0=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalTURN.g:480:2: ( (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) )
            // InternalTURN.g:481:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            {
            // InternalTURN.g:481:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            // InternalTURN.g:482:3: otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteURNspecAccess().getLeftCurlyBracketKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getConcreteURNspecAccess().getDescriptionKeyword_1());
            		
            // InternalTURN.g:490:3: ( (lv_description_2_0= RULE_STRING ) )
            // InternalTURN.g:491:4: (lv_description_2_0= RULE_STRING )
            {
            // InternalTURN.g:491:4: (lv_description_2_0= RULE_STRING )
            // InternalTURN.g:492:5: lv_description_2_0= RULE_STRING
            {
            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_description_2_0, grammarAccess.getConcreteURNspecAccess().getDescriptionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getConcreteURNspecAccess().getAuthorKeyword_3());
            		
            // InternalTURN.g:512:3: ( (lv_author_4_0= RULE_STRING ) )
            // InternalTURN.g:513:4: (lv_author_4_0= RULE_STRING )
            {
            // InternalTURN.g:513:4: (lv_author_4_0= RULE_STRING )
            // InternalTURN.g:514:5: lv_author_4_0= RULE_STRING
            {
            lv_author_4_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_author_4_0, grammarAccess.getConcreteURNspecAccess().getAuthorSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getConcreteURNspecAccess().getCreatedKeyword_5());
            		
            // InternalTURN.g:534:3: ( (lv_created_6_0= RULE_STRING ) )
            // InternalTURN.g:535:4: (lv_created_6_0= RULE_STRING )
            {
            // InternalTURN.g:535:4: (lv_created_6_0= RULE_STRING )
            // InternalTURN.g:536:5: lv_created_6_0= RULE_STRING
            {
            lv_created_6_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_created_6_0, grammarAccess.getConcreteURNspecAccess().getCreatedSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"created",
            						lv_created_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getConcreteURNspecAccess().getModifiedKeyword_7());
            		
            // InternalTURN.g:556:3: ( (lv_modified_8_0= RULE_STRING ) )
            // InternalTURN.g:557:4: (lv_modified_8_0= RULE_STRING )
            {
            // InternalTURN.g:557:4: (lv_modified_8_0= RULE_STRING )
            // InternalTURN.g:558:5: lv_modified_8_0= RULE_STRING
            {
            lv_modified_8_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

            					newLeafNode(lv_modified_8_0, grammarAccess.getConcreteURNspecAccess().getModifiedSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"modified",
            						lv_modified_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,20,FOLLOW_9); 

            			newLeafNode(otherlv_9, grammarAccess.getConcreteURNspecAccess().getVersionKeyword_9());
            		
            // InternalTURN.g:578:3: ( (lv_specVersion_10_0= RULE_STRING ) )
            // InternalTURN.g:579:4: (lv_specVersion_10_0= RULE_STRING )
            {
            // InternalTURN.g:579:4: (lv_specVersion_10_0= RULE_STRING )
            // InternalTURN.g:580:5: lv_specVersion_10_0= RULE_STRING
            {
            lv_specVersion_10_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_specVersion_10_0, grammarAccess.getConcreteURNspecAccess().getSpecVersionSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"specVersion",
            						lv_specVersion_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,21,FOLLOW_9); 

            			newLeafNode(otherlv_11, grammarAccess.getConcreteURNspecAccess().getUrnVersionKeyword_11());
            		
            // InternalTURN.g:600:3: ( (lv_urnVersion_12_0= RULE_STRING ) )
            // InternalTURN.g:601:4: (lv_urnVersion_12_0= RULE_STRING )
            {
            // InternalTURN.g:601:4: (lv_urnVersion_12_0= RULE_STRING )
            // InternalTURN.g:602:5: lv_urnVersion_12_0= RULE_STRING
            {
            lv_urnVersion_12_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_urnVersion_12_0, grammarAccess.getConcreteURNspecAccess().getUrnVersionSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"urnVersion",
            						lv_urnVersion_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getConcreteURNspecAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteURNspec"


    // $ANTLR start "entryRuleConcern"
    // InternalTURN.g:626:1: entryRuleConcern returns [EObject current=null] : iv_ruleConcern= ruleConcern EOF ;
    public final EObject entryRuleConcern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcern = null;


        try {
            // InternalTURN.g:626:48: (iv_ruleConcern= ruleConcern EOF )
            // InternalTURN.g:627:2: iv_ruleConcern= ruleConcern EOF
            {
             newCompositeNode(grammarAccess.getConcernRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcern=ruleConcern();

            state._fsp--;

             current =iv_ruleConcern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcern"


    // $ANTLR start "ruleConcern"
    // InternalTURN.g:633:1: ruleConcern returns [EObject current=null] : (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? otherlv_5= '{' ( ( ruleQualifiedName ) ) (otherlv_7= ',' ( ( ruleQualifiedName ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleConcern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:639:2: ( (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? otherlv_5= '{' ( ( ruleQualifiedName ) ) (otherlv_7= ',' ( ( ruleQualifiedName ) ) )* otherlv_9= '}' ) )
            // InternalTURN.g:640:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? otherlv_5= '{' ( ( ruleQualifiedName ) ) (otherlv_7= ',' ( ( ruleQualifiedName ) ) )* otherlv_9= '}' )
            {
            // InternalTURN.g:640:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? otherlv_5= '{' ( ( ruleQualifiedName ) ) (otherlv_7= ',' ( ( ruleQualifiedName ) ) )* otherlv_9= '}' )
            // InternalTURN.g:641:3: otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? otherlv_5= '{' ( ( ruleQualifiedName ) ) (otherlv_7= ',' ( ( ruleQualifiedName ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcernAccess().getConcernKeyword_0());
            		
            // InternalTURN.g:645:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:646:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:646:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:647:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:664:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:665:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:665:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:666:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getConcernAccess().getColonKeyword_3());
            		
            // InternalTURN.g:687:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTURN.g:688:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTURN.g:688:4: (lv_condition_4_0= ruleCondition )
                    // InternalTURN.g:689:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getConcernAccess().getConditionConditionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_6);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConcernRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getConcernAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalTURN.g:710:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:711:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:711:4: ( ruleQualifiedName )
            // InternalTURN.g:712:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcernRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcernAccess().getElementURNmodelElementCrossReference_6_0());
            				
            pushFollow(FOLLOW_19);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:726:3: (otherlv_7= ',' ( ( ruleQualifiedName ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalTURN.g:727:4: otherlv_7= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_7=(Token)match(input,24,FOLLOW_3); 

            	    				newLeafNode(otherlv_7, grammarAccess.getConcernAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalTURN.g:731:4: ( ( ruleQualifiedName ) )
            	    // InternalTURN.g:732:5: ( ruleQualifiedName )
            	    {
            	    // InternalTURN.g:732:5: ( ruleQualifiedName )
            	    // InternalTURN.g:733:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getConcernRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getConcernAccess().getElementsURNmodelElementCrossReference_7_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getConcernAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcern"


    // $ANTLR start "entryRuleLongName"
    // InternalTURN.g:756:1: entryRuleLongName returns [EObject current=null] : iv_ruleLongName= ruleLongName EOF ;
    public final EObject entryRuleLongName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongName = null;


        try {
            // InternalTURN.g:756:49: (iv_ruleLongName= ruleLongName EOF )
            // InternalTURN.g:757:2: iv_ruleLongName= ruleLongName EOF
            {
             newCompositeNode(grammarAccess.getLongNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongName=ruleLongName();

            state._fsp--;

             current =iv_ruleLongName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongName"


    // $ANTLR start "ruleLongName"
    // InternalTURN.g:763:1: ruleLongName returns [EObject current=null] : ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleLongName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_longname_2_1=null;
        Token lv_longname_2_2=null;


        	enterRule();

        try {
            // InternalTURN.g:769:2: ( ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) )
            // InternalTURN.g:770:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            {
            // InternalTURN.g:770:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            // InternalTURN.g:771:3: () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            {
            // InternalTURN.g:771:3: ()
            // InternalTURN.g:772:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLongNameAccess().getLongNameAction_0(),
            					current);
            			

            }

            // InternalTURN.g:778:3: (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTURN.g:779:4: otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_20); 

                    				newLeafNode(otherlv_1, grammarAccess.getLongNameAccess().getNumberSignKeyword_1_0());
                    			
                    // InternalTURN.g:783:4: ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    // InternalTURN.g:784:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    {
                    // InternalTURN.g:784:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    // InternalTURN.g:785:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    {
                    // InternalTURN.g:785:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==RULE_STRING) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalTURN.g:786:7: lv_longname_2_1= RULE_ID
                            {
                            lv_longname_2_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_1, grammarAccess.getLongNameAccess().getLongnameIDTerminalRuleCall_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_1,
                            								"org.eclipse.xtext.common.Terminals.ID");
                            						

                            }
                            break;
                        case 2 :
                            // InternalTURN.g:801:7: lv_longname_2_2= RULE_STRING
                            {
                            lv_longname_2_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_2, grammarAccess.getLongNameAccess().getLongnameSTRINGTerminalRuleCall_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_2,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongName"


    // $ANTLR start "entryRuleCondition"
    // InternalTURN.g:823:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalTURN.g:823:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalTURN.g:824:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalTURN.g:830:1: ruleCondition returns [EObject current=null] : (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_1_0 = null;

        EObject lv_info_4_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:836:2: ( (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) )
            // InternalTURN.g:837:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            {
            // InternalTURN.g:837:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            // InternalTURN.g:838:3: otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalTURN.g:842:3: ( (lv_expression_1_0= ruleText ) )
            // InternalTURN.g:843:4: (lv_expression_1_0= ruleText )
            {
            // InternalTURN.g:843:4: (lv_expression_1_0= ruleText )
            // InternalTURN.g:844:5: lv_expression_1_0= ruleText
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getExpressionTextParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_expression_1_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"org.xtext.example.mydsl.TURN.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getRightSquareBracketKeyword_2());
            		
            // InternalTURN.g:865:3: (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==14) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==RULE_STRING||LA18_1==15) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalTURN.g:866:4: otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_24); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalTURN.g:870:4: ( (lv_info_4_0= ruleConcreteCondition ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_STRING) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalTURN.g:871:5: (lv_info_4_0= ruleConcreteCondition )
                            {
                            // InternalTURN.g:871:5: (lv_info_4_0= ruleConcreteCondition )
                            // InternalTURN.g:872:6: lv_info_4_0= ruleConcreteCondition
                            {

                            						newCompositeNode(grammarAccess.getConditionAccess().getInfoConcreteConditionParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_15);
                            lv_info_4_0=ruleConcreteCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getConditionRule());
                            						}
                            						set(
                            							current,
                            							"info",
                            							lv_info_4_0,
                            							"org.xtext.example.mydsl.TURN.ConcreteCondition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleConcreteCondition"
    // InternalTURN.g:898:1: entryRuleConcreteCondition returns [EObject current=null] : iv_ruleConcreteCondition= ruleConcreteCondition EOF ;
    public final EObject entryRuleConcreteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteCondition = null;


        try {
            // InternalTURN.g:898:58: (iv_ruleConcreteCondition= ruleConcreteCondition EOF )
            // InternalTURN.g:899:2: iv_ruleConcreteCondition= ruleConcreteCondition EOF
            {
             newCompositeNode(grammarAccess.getConcreteConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteCondition=ruleConcreteCondition();

            state._fsp--;

             current =iv_ruleConcreteCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteCondition"


    // $ANTLR start "ruleConcreteCondition"
    // InternalTURN.g:905:1: ruleConcreteCondition returns [EObject current=null] : ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;
        Token lv_description_1_0=null;


        	enterRule();

        try {
            // InternalTURN.g:911:2: ( ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // InternalTURN.g:912:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // InternalTURN.g:912:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // InternalTURN.g:913:3: ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // InternalTURN.g:913:3: ( (lv_label_0_0= RULE_STRING ) )
            // InternalTURN.g:914:4: (lv_label_0_0= RULE_STRING )
            {
            // InternalTURN.g:914:4: (lv_label_0_0= RULE_STRING )
            // InternalTURN.g:915:5: lv_label_0_0= RULE_STRING
            {
            lv_label_0_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_label_0_0, grammarAccess.getConcreteConditionAccess().getLabelSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"label",
            						lv_label_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTURN.g:931:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalTURN.g:932:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalTURN.g:932:4: (lv_description_1_0= RULE_STRING )
            // InternalTURN.g:933:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_description_1_0, grammarAccess.getConcreteConditionAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteCondition"


    // $ANTLR start "entryRuleURNlink"
    // InternalTURN.g:953:1: entryRuleURNlink returns [EObject current=null] : iv_ruleURNlink= ruleURNlink EOF ;
    public final EObject entryRuleURNlink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNlink = null;


        try {
            // InternalTURN.g:953:48: (iv_ruleURNlink= ruleURNlink EOF )
            // InternalTURN.g:954:2: iv_ruleURNlink= ruleURNlink EOF
            {
             newCompositeNode(grammarAccess.getURNlinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNlink=ruleURNlink();

            state._fsp--;

             current =iv_ruleURNlink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNlink"


    // $ANTLR start "ruleURNlink"
    // InternalTURN.g:960:1: ruleURNlink returns [EObject current=null] : (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleURNlink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:966:2: ( (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) )
            // InternalTURN.g:967:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            {
            // InternalTURN.g:967:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            // InternalTURN.g:968:3: otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getURNlinkAccess().getLinkKeyword_0());
            		
            // InternalTURN.g:972:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalTURN.g:973:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':'
                    {
                    // InternalTURN.g:973:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTURN.g:974:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:974:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTURN.g:975:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:992:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTURN.g:993:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTURN.g:993:5: (lv_longName_2_0= ruleLongName )
                    // InternalTURN.g:994:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_25); 

                    				newLeafNode(otherlv_3, grammarAccess.getURNlinkAccess().getColonKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalTURN.g:1016:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTURN.g:1017:4: otherlv_4= 'type' ( (lv_type_5_0= ruleText ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getURNlinkAccess().getTypeKeyword_2_0());
                    			
                    // InternalTURN.g:1021:4: ( (lv_type_5_0= ruleText ) )
                    // InternalTURN.g:1022:5: (lv_type_5_0= ruleText )
                    {
                    // InternalTURN.g:1022:5: (lv_type_5_0= ruleText )
                    // InternalTURN.g:1023:6: lv_type_5_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getTypeTextParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_type_5_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
                    							"org.xtext.example.mydsl.TURN.Text");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:1041:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:1042:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:1042:4: ( ruleQualifiedName )
            // InternalTURN.g:1043:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getFromElemURNmodelElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_26);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getURNlinkAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalTURN.g:1061:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:1062:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:1062:4: ( ruleQualifiedName )
            // InternalTURN.g:1063:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getToElemURNmodelElementCrossReference_5_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNlink"


    // $ANTLR start "entryRuleMetadata"
    // InternalTURN.g:1081:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalTURN.g:1081:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalTURN.g:1082:2: iv_ruleMetadata= ruleMetadata EOF
            {
             newCompositeNode(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadata=ruleMetadata();

            state._fsp--;

             current =iv_ruleMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalTURN.g:1088:1: ruleMetadata returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '{' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) otherlv_6= '}' ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1094:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '{' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) otherlv_6= '}' ) )
            // InternalTURN.g:1095:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '{' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) otherlv_6= '}' )
            {
            // InternalTURN.g:1095:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '{' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) otherlv_6= '}' )
            // InternalTURN.g:1096:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '{' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) otherlv_6= '}'
            {
            // InternalTURN.g:1096:3: ( (otherlv_0= RULE_ID ) )
            // InternalTURN.g:1097:4: (otherlv_0= RULE_ID )
            {
            // InternalTURN.g:1097:4: (otherlv_0= RULE_ID )
            // InternalTURN.g:1098:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetadataRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(otherlv_0, grammarAccess.getMetadataAccess().getElemURNmodelElementCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getMetadataAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getMetadataAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTURN.g:1117:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTURN.g:1118:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTURN.g:1118:4: (lv_name_3_0= RULE_ID )
            // InternalTURN.g:1119:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_3_0, grammarAccess.getMetadataAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetadataRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,31,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getMetadataAccess().getEqualsSignKeyword_4());
            		
            // InternalTURN.g:1139:3: ( (lv_value_5_0= ruleText ) )
            // InternalTURN.g:1140:4: (lv_value_5_0= ruleText )
            {
            // InternalTURN.g:1140:4: (lv_value_5_0= ruleText )
            // InternalTURN.g:1141:5: lv_value_5_0= ruleText
            {

            					newCompositeNode(grammarAccess.getMetadataAccess().getValueTextParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_15);
            lv_value_5_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetadataRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"org.xtext.example.mydsl.TURN.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMetadataAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleActor"
    // InternalTURN.g:1166:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTURN.g:1166:46: (iv_ruleActor= ruleActor EOF )
            // InternalTURN.g:1167:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalTURN.g:1173:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_elems_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1179:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) )
            // InternalTURN.g:1180:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            {
            // InternalTURN.g:1180:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            // InternalTURN.g:1181:3: otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalTURN.g:1185:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:1186:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:1186:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:1187:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:1204:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:1205:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:1205:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:1206:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_29); 

            			newLeafNode(otherlv_3, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTURN.g:1227:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTURN.g:1228:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getActorAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTURN.g:1232:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==100||(LA21_0>=114 && LA21_0<=116)) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_INT||(LA21_0>=54 && LA21_0<=55)) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalTURN.g:1233:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTURN.g:1233:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTURN.g:1234:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTURN.g:1234:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTURN.g:1235:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.xtext.example.mydsl.TURN.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTURN.g:1253:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTURN.g:1253:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTURN.g:1254:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTURN.g:1254:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTURN.g:1255:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.xtext.example.mydsl.TURN.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTURN.g:1274:3: ( (lv_elems_7_0= ruleIntentionalElement ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=101 && LA23_0<=106)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalTURN.g:1275:4: (lv_elems_7_0= ruleIntentionalElement )
            	    {
            	    // InternalTURN.g:1275:4: (lv_elems_7_0= ruleIntentionalElement )
            	    // InternalTURN.g:1276:5: lv_elems_7_0= ruleIntentionalElement
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getElemsIntentionalElementParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_elems_7_0=ruleIntentionalElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elems",
            	    						lv_elems_7_0,
            	    						"org.xtext.example.mydsl.TURN.IntentionalElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleIntentionalElement"
    // InternalTURN.g:1301:1: entryRuleIntentionalElement returns [EObject current=null] : iv_ruleIntentionalElement= ruleIntentionalElement EOF ;
    public final EObject entryRuleIntentionalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentionalElement = null;


        try {
            // InternalTURN.g:1301:59: (iv_ruleIntentionalElement= ruleIntentionalElement EOF )
            // InternalTURN.g:1302:2: iv_ruleIntentionalElement= ruleIntentionalElement EOF
            {
             newCompositeNode(grammarAccess.getIntentionalElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentionalElement=ruleIntentionalElement();

            state._fsp--;

             current =iv_ruleIntentionalElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntentionalElement"


    // $ANTLR start "ruleIntentionalElement"
    // InternalTURN.g:1308:1: ruleIntentionalElement returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) ;
    public final EObject ruleIntentionalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_unit_8_0=null;
        Token otherlv_10=null;
        Enumerator lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_linksSrc_9_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1314:2: ( ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) )
            // InternalTURN.g:1315:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            {
            // InternalTURN.g:1315:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            // InternalTURN.g:1316:3: ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}'
            {
            // InternalTURN.g:1316:3: ( (lv_type_0_0= ruleIntentionalElementType ) )
            // InternalTURN.g:1317:4: (lv_type_0_0= ruleIntentionalElementType )
            {
            // InternalTURN.g:1317:4: (lv_type_0_0= ruleIntentionalElementType )
            // InternalTURN.g:1318:5: lv_type_0_0= ruleIntentionalElementType
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getTypeIntentionalElementTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntentionalElementType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.example.mydsl.TURN.IntentionalElementType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:1335:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:1336:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:1336:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:1337:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:1354:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:1355:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:1355:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:1356:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_32); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentionalElementAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTURN.g:1377:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTURN.g:1378:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentionalElementAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTURN.g:1382:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==100||(LA24_0>=114 && LA24_0<=116)) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==RULE_INT||(LA24_0>=54 && LA24_0<=55)) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalTURN.g:1383:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTURN.g:1383:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTURN.g:1384:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTURN.g:1384:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTURN.g:1385:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_33);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.xtext.example.mydsl.TURN.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTURN.g:1403:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTURN.g:1403:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTURN.g:1404:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTURN.g:1404:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTURN.g:1405:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_33);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.xtext.example.mydsl.TURN.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTURN.g:1424:3: (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTURN.g:1425:4: otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntentionalElementAccess().getUnitKeyword_5_0());
                    			
                    // InternalTURN.g:1429:4: ( (lv_unit_8_0= RULE_STRING ) )
                    // InternalTURN.g:1430:5: (lv_unit_8_0= RULE_STRING )
                    {
                    // InternalTURN.g:1430:5: (lv_unit_8_0= RULE_STRING )
                    // InternalTURN.g:1431:6: lv_unit_8_0= RULE_STRING
                    {
                    lv_unit_8_0=(Token)match(input,RULE_STRING,FOLLOW_34); 

                    						newLeafNode(lv_unit_8_0, grammarAccess.getIntentionalElementAccess().getUnitSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIntentionalElementRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unit",
                    							lv_unit_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:1448:3: ( (lv_linksSrc_9_0= ruleElementLink ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID||LA27_0==35||LA27_0==39||LA27_0==77||LA27_0==79||LA27_0==117) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalTURN.g:1449:4: (lv_linksSrc_9_0= ruleElementLink )
            	    {
            	    // InternalTURN.g:1449:4: (lv_linksSrc_9_0= ruleElementLink )
            	    // InternalTURN.g:1450:5: lv_linksSrc_9_0= ruleElementLink
            	    {

            	    					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLinksSrcElementLinkParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_linksSrc_9_0=ruleElementLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"linksSrc",
            	    						lv_linksSrc_9_0,
            	    						"org.xtext.example.mydsl.TURN.ElementLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIntentionalElementAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElement"


    // $ANTLR start "entryRuleElementLink"
    // InternalTURN.g:1475:1: entryRuleElementLink returns [EObject current=null] : iv_ruleElementLink= ruleElementLink EOF ;
    public final EObject entryRuleElementLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementLink = null;


        try {
            // InternalTURN.g:1475:52: (iv_ruleElementLink= ruleElementLink EOF )
            // InternalTURN.g:1476:2: iv_ruleElementLink= ruleElementLink EOF
            {
             newCompositeNode(grammarAccess.getElementLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementLink=ruleElementLink();

            state._fsp--;

             current =iv_ruleElementLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementLink"


    // $ANTLR start "ruleElementLink"
    // InternalTURN.g:1482:1: ruleElementLink returns [EObject current=null] : (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) ;
    public final EObject ruleElementLink() throws RecognitionException {
        EObject current = null;

        EObject this_Contribution_0 = null;

        EObject this_Decomposition_1 = null;

        EObject this_Dependency_2 = null;



        	enterRule();

        try {
            // InternalTURN.g:1488:2: ( (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) )
            // InternalTURN.g:1489:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            {
            // InternalTURN.g:1489:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalTURN.g:1490:3: this_Contribution_0= ruleContribution
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getContributionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Contribution_0=ruleContribution();

                    state._fsp--;


                    			current = this_Contribution_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:1499:3: this_Decomposition_1= ruleDecomposition
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDecompositionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Decomposition_1=ruleDecomposition();

                    state._fsp--;


                    			current = this_Decomposition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTURN.g:1508:3: this_Dependency_2= ruleDependency
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDependencyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Dependency_2=ruleDependency();

                    state._fsp--;


                    			current = this_Dependency_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementLink"


    // $ANTLR start "entryRuleContribution"
    // InternalTURN.g:1520:1: entryRuleContribution returns [EObject current=null] : iv_ruleContribution= ruleContribution EOF ;
    public final EObject entryRuleContribution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContribution = null;


        try {
            // InternalTURN.g:1520:53: (iv_ruleContribution= ruleContribution EOF )
            // InternalTURN.g:1521:2: iv_ruleContribution= ruleContribution EOF
            {
             newCompositeNode(grammarAccess.getContributionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContribution=ruleContribution();

            state._fsp--;

             current =iv_ruleContribution; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContribution"


    // $ANTLR start "ruleContribution"
    // InternalTURN.g:1527:1: ruleContribution returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContribution() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_correlation_4_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_contribution_6_0 = null;

        AntlrDatatypeRuleToken lv_quantitativeContribution_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1533:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTURN.g:1534:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTURN.g:1534:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            // InternalTURN.g:1535:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            {
            // InternalTURN.g:1535:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTURN.g:1536:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTURN.g:1536:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTURN.g:1537:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:1537:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTURN.g:1538:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:1555:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTURN.g:1556:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTURN.g:1556:5: (lv_longName_1_0= ruleLongName )
                    // InternalTURN.g:1557:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getContributionAccess().getContributesToKeyword_1());
            		
            // InternalTURN.g:1579:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:1580:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:1580:4: ( ruleQualifiedName )
            // InternalTURN.g:1581:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:1595:3: ( (lv_correlation_4_0= 'correlated' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTURN.g:1596:4: (lv_correlation_4_0= 'correlated' )
                    {
                    // InternalTURN.g:1596:4: (lv_correlation_4_0= 'correlated' )
                    // InternalTURN.g:1597:5: lv_correlation_4_0= 'correlated'
                    {
                    lv_correlation_4_0=(Token)match(input,36,FOLLOW_38); 

                    					newLeafNode(lv_correlation_4_0, grammarAccess.getContributionAccess().getCorrelationCorrelatedKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContributionRule());
                    					}
                    					setWithLastConsumed(current, "correlation", true, "correlated");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,37,FOLLOW_39); 

            			newLeafNode(otherlv_5, grammarAccess.getContributionAccess().getWithKeyword_4());
            		
            // InternalTURN.g:1613:3: ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==99||(LA31_0>=107 && LA31_0<=113)) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_INT||(LA31_0>=54 && LA31_0<=55)) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalTURN.g:1614:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    {
                    // InternalTURN.g:1614:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    // InternalTURN.g:1615:5: (lv_contribution_6_0= ruleContributionType )
                    {
                    // InternalTURN.g:1615:5: (lv_contribution_6_0= ruleContributionType )
                    // InternalTURN.g:1616:6: lv_contribution_6_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getContributionContributionTypeEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contribution_6_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"contribution",
                    							lv_contribution_6_0,
                    							"org.xtext.example.mydsl.TURN.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:1634:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    {
                    // InternalTURN.g:1634:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    // InternalTURN.g:1635:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    {
                    // InternalTURN.g:1635:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    // InternalTURN.g:1636:6: lv_quantitativeContribution_7_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getQuantitativeContributionQuantitativeValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_quantitativeContribution_7_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"quantitativeContribution",
                    							lv_quantitativeContribution_7_0,
                    							"org.xtext.example.mydsl.TURN.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContribution"


    // $ANTLR start "entryRuleDecomposition"
    // InternalTURN.g:1658:1: entryRuleDecomposition returns [EObject current=null] : iv_ruleDecomposition= ruleDecomposition EOF ;
    public final EObject entryRuleDecomposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecomposition = null;


        try {
            // InternalTURN.g:1658:54: (iv_ruleDecomposition= ruleDecomposition EOF )
            // InternalTURN.g:1659:2: iv_ruleDecomposition= ruleDecomposition EOF
            {
             newCompositeNode(grammarAccess.getDecompositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecomposition=ruleDecomposition();

            state._fsp--;

             current =iv_ruleDecomposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecomposition"


    // $ANTLR start "ruleDecomposition"
    // InternalTURN.g:1665:1: ruleDecomposition returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDecomposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_decompositionType_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1671:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) )
            // InternalTURN.g:1672:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            {
            // InternalTURN.g:1672:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            // InternalTURN.g:1673:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) )
            {
            // InternalTURN.g:1673:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTURN.g:1674:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTURN.g:1674:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTURN.g:1675:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:1675:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTURN.g:1676:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:1693:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTURN.g:1694:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTURN.g:1694:5: (lv_longName_1_0= ruleLongName )
                    // InternalTURN.g:1695:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:1713:3: ( (lv_decompositionType_2_0= ruleDecompositionType ) )
            // InternalTURN.g:1714:4: (lv_decompositionType_2_0= ruleDecompositionType )
            {
            // InternalTURN.g:1714:4: (lv_decompositionType_2_0= ruleDecompositionType )
            // InternalTURN.g:1715:5: lv_decompositionType_2_0= ruleDecompositionType
            {

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDecompositionTypeDecompositionTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_decompositionType_2_0=ruleDecompositionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDecompositionRule());
            					}
            					set(
            						current,
            						"decompositionType",
            						lv_decompositionType_2_0,
            						"org.xtext.example.mydsl.TURN.DecompositionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDecompositionAccess().getDecomposesKeyword_2());
            		
            // InternalTURN.g:1736:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:1737:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:1737:4: ( ruleQualifiedName )
            // InternalTURN.g:1738:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecompositionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDestIntentionalElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecomposition"


    // $ANTLR start "entryRuleDependency"
    // InternalTURN.g:1756:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalTURN.g:1756:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalTURN.g:1757:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalTURN.g:1763:1: ruleDependency returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1769:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) )
            // InternalTURN.g:1770:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            {
            // InternalTURN.g:1770:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            // InternalTURN.g:1771:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) )
            {
            // InternalTURN.g:1771:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTURN.g:1772:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTURN.g:1772:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTURN.g:1773:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:1773:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTURN.g:1774:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:1791:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTURN.g:1792:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTURN.g:1792:5: (lv_longName_1_0= ruleLongName )
                    // InternalTURN.g:1793:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDependencyAccess().getDependsOnKeyword_1());
            		
            // InternalTURN.g:1815:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:1816:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:1816:4: ( ruleQualifiedName )
            // InternalTURN.g:1817:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDependencyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDependencyAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRuleArtificialRule"
    // InternalTURN.g:1835:1: entryRuleArtificialRule returns [EObject current=null] : iv_ruleArtificialRule= ruleArtificialRule EOF ;
    public final EObject entryRuleArtificialRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtificialRule = null;


        try {
            // InternalTURN.g:1835:55: (iv_ruleArtificialRule= ruleArtificialRule EOF )
            // InternalTURN.g:1836:2: iv_ruleArtificialRule= ruleArtificialRule EOF
            {
             newCompositeNode(grammarAccess.getArtificialRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtificialRule=ruleArtificialRule();

            state._fsp--;

             current =iv_ruleArtificialRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArtificialRule"


    // $ANTLR start "ruleArtificialRule"
    // InternalTURN.g:1842:1: ruleArtificialRule returns [EObject current=null] : ( (lv_longName_0_0= RULE_STRING ) )? ;
    public final EObject ruleArtificialRule() throws RecognitionException {
        EObject current = null;

        Token lv_longName_0_0=null;


        	enterRule();

        try {
            // InternalTURN.g:1848:2: ( ( (lv_longName_0_0= RULE_STRING ) )? )
            // InternalTURN.g:1849:2: ( (lv_longName_0_0= RULE_STRING ) )?
            {
            // InternalTURN.g:1849:2: ( (lv_longName_0_0= RULE_STRING ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_STRING) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTURN.g:1850:3: (lv_longName_0_0= RULE_STRING )
                    {
                    // InternalTURN.g:1850:3: (lv_longName_0_0= RULE_STRING )
                    // InternalTURN.g:1851:4: lv_longName_0_0= RULE_STRING
                    {
                    lv_longName_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    				newLeafNode(lv_longName_0_0, grammarAccess.getArtificialRuleAccess().getLongNameSTRINGTerminalRuleCall_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArtificialRuleRule());
                    				}
                    				setWithLastConsumed(
                    					current,
                    					"longName",
                    					lv_longName_0_0,
                    					"org.eclipse.xtext.common.Terminals.STRING");
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArtificialRule"


    // $ANTLR start "entryRuleStrategiesGroup"
    // InternalTURN.g:1870:1: entryRuleStrategiesGroup returns [EObject current=null] : iv_ruleStrategiesGroup= ruleStrategiesGroup EOF ;
    public final EObject entryRuleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategiesGroup = null;


        try {
            // InternalTURN.g:1870:56: (iv_ruleStrategiesGroup= ruleStrategiesGroup EOF )
            // InternalTURN.g:1871:2: iv_ruleStrategiesGroup= ruleStrategiesGroup EOF
            {
             newCompositeNode(grammarAccess.getStrategiesGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStrategiesGroup=ruleStrategiesGroup();

            state._fsp--;

             current =iv_ruleStrategiesGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStrategiesGroup"


    // $ANTLR start "ruleStrategiesGroup"
    // InternalTURN.g:1877:1: ruleStrategiesGroup returns [EObject current=null] : (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1883:2: ( (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTURN.g:1884:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTURN.g:1884:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTURN.g:1885:3: otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStrategiesGroupAccess().getStrategiesGroupKeyword_0());
            		
            // InternalTURN.g:1889:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:1890:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:1890:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:1891:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:1908:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:1909:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:1909:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:1910:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getStrategiesGroupAccess().getColonKeyword_3());
            		
            // InternalTURN.g:1931:3: ( (otherlv_4= RULE_ID ) )
            // InternalTURN.g:1932:4: (otherlv_4= RULE_ID )
            {
            // InternalTURN.g:1932:4: (otherlv_4= RULE_ID )
            // InternalTURN.g:1933:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStrategiesGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(otherlv_4, grammarAccess.getStrategiesGroupAccess().getEvalStrategyEvaluationStrategyCrossReference_4_0());
            				

            }


            }

            // InternalTURN.g:1944:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==24) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalTURN.g:1945:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getStrategiesGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTURN.g:1949:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTURN.g:1950:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTURN.g:1950:5: (otherlv_6= RULE_ID )
            	    // InternalTURN.g:1951:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStrategiesGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_45); 

            	    						newLeafNode(otherlv_6, grammarAccess.getStrategiesGroupAccess().getEvalStrategiesEvaluationStrategyCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStrategiesGroup"


    // $ANTLR start "entryRuleEvaluationStrategy"
    // InternalTURN.g:1967:1: entryRuleEvaluationStrategy returns [EObject current=null] : iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF ;
    public final EObject entryRuleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluationStrategy = null;


        try {
            // InternalTURN.g:1967:59: (iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF )
            // InternalTURN.g:1968:2: iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF
            {
             newCompositeNode(grammarAccess.getEvaluationStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluationStrategy=ruleEvaluationStrategy();

            state._fsp--;

             current =iv_ruleEvaluationStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluationStrategy"


    // $ANTLR start "ruleEvaluationStrategy"
    // InternalTURN.g:1974:1: ruleEvaluationStrategy returns [EObject current=null] : (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )? otherlv_10= '}' ) ;
    public final EObject ruleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_info_4_0 = null;

        EObject lv_evaluations_5_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:1980:2: ( (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )? otherlv_10= '}' ) )
            // InternalTURN.g:1981:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )? otherlv_10= '}' )
            {
            // InternalTURN.g:1981:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )? otherlv_10= '}' )
            // InternalTURN.g:1982:3: otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEvaluationStrategyAccess().getStrategyKeyword_0());
            		
            // InternalTURN.g:1986:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:1987:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:1987:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:1988:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2005:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:2006:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:2006:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:2007:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_46); 

            			newLeafNode(otherlv_3, grammarAccess.getEvaluationStrategyAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTURN.g:2028:3: ( (lv_info_4_0= ruleConcreteStrategy ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==17) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTURN.g:2029:4: (lv_info_4_0= ruleConcreteStrategy )
                    {
                    // InternalTURN.g:2029:4: (lv_info_4_0= ruleConcreteStrategy )
                    // InternalTURN.g:2030:5: lv_info_4_0= ruleConcreteStrategy
                    {

                    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getInfoConcreteStrategyParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_47);
                    lv_info_4_0=ruleConcreteStrategy();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
                    					}
                    					set(
                    						current,
                    						"info",
                    						lv_info_4_0,
                    						"org.xtext.example.mydsl.TURN.ConcreteStrategy");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTURN.g:2047:3: ( (lv_evaluations_5_0= ruleEvaluation ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTURN.g:2048:4: (lv_evaluations_5_0= ruleEvaluation )
            	    {
            	    // InternalTURN.g:2048:4: (lv_evaluations_5_0= ruleEvaluation )
            	    // InternalTURN.g:2049:5: lv_evaluations_5_0= ruleEvaluation
            	    {

            	    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getEvaluationsEvaluationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_evaluations_5_0=ruleEvaluation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"evaluations",
            	    						lv_evaluations_5_0,
            	    						"org.xtext.example.mydsl.TURN.Evaluation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // InternalTURN.g:2066:3: (otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==42) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalTURN.g:2067:4: otherlv_6= 'includes' otherlv_7= '{' ( (otherlv_8= RULE_ID ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getEvaluationStrategyAccess().getIncludesKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getEvaluationStrategyAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalTURN.g:2075:4: ( (otherlv_8= RULE_ID ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalTURN.g:2076:5: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalTURN.g:2076:5: (otherlv_8= RULE_ID )
                    	    // InternalTURN.g:2077:6: otherlv_8= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    	    						}
                    	    					
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategiesEvaluationStrategyCrossReference_6_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FOLLOW_15); 

                    				newLeafNode(otherlv_9, grammarAccess.getEvaluationStrategyAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEvaluationStrategyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluationStrategy"


    // $ANTLR start "entryRuleConcreteStrategy"
    // InternalTURN.g:2101:1: entryRuleConcreteStrategy returns [EObject current=null] : iv_ruleConcreteStrategy= ruleConcreteStrategy EOF ;
    public final EObject entryRuleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStrategy = null;


        try {
            // InternalTURN.g:2101:57: (iv_ruleConcreteStrategy= ruleConcreteStrategy EOF )
            // InternalTURN.g:2102:2: iv_ruleConcreteStrategy= ruleConcreteStrategy EOF
            {
             newCompositeNode(grammarAccess.getConcreteStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteStrategy=ruleConcreteStrategy();

            state._fsp--;

             current =iv_ruleConcreteStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteStrategy"


    // $ANTLR start "ruleConcreteStrategy"
    // InternalTURN.g:2108:1: ruleConcreteStrategy returns [EObject current=null] : (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_author_1_0=null;


        	enterRule();

        try {
            // InternalTURN.g:2114:2: ( (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) )
            // InternalTURN.g:2115:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            {
            // InternalTURN.g:2115:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            // InternalTURN.g:2116:3: otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteStrategyAccess().getAuthorKeyword_0());
            		
            // InternalTURN.g:2120:3: ( (lv_author_1_0= RULE_STRING ) )
            // InternalTURN.g:2121:4: (lv_author_1_0= RULE_STRING )
            {
            // InternalTURN.g:2121:4: (lv_author_1_0= RULE_STRING )
            // InternalTURN.g:2122:5: lv_author_1_0= RULE_STRING
            {
            lv_author_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_author_1_0, grammarAccess.getConcreteStrategyAccess().getAuthorSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteStrategyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteStrategy"


    // $ANTLR start "entryRuleEvaluation"
    // InternalTURN.g:2142:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalTURN.g:2142:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalTURN.g:2143:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalTURN.g:2149:1: ruleEvaluation returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_qualitativeEvaluation_3_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_4_0 = null;

        EObject lv_indicatorEval_5_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2155:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) )
            // InternalTURN.g:2156:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            {
            // InternalTURN.g:2156:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalTURN.g:2157:3: ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalTURN.g:2157:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:2158:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:2158:4: ( ruleQualifiedName )
            // InternalTURN.g:2159:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEvaluationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEvaluationAccess().getIntElementIntentionalElementCrossReference_0_0());
            				
            pushFollow(FOLLOW_48);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2173:3: ( (lv_exceeds_1_0= 'exceeding' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==43) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTURN.g:2174:4: (lv_exceeds_1_0= 'exceeding' )
                    {
                    // InternalTURN.g:2174:4: (lv_exceeds_1_0= 'exceeding' )
                    // InternalTURN.g:2175:5: lv_exceeds_1_0= 'exceeding'
                    {
                    lv_exceeds_1_0=(Token)match(input,43,FOLLOW_48); 

                    					newLeafNode(lv_exceeds_1_0, grammarAccess.getEvaluationAccess().getExceedsExceedingKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEvaluationRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            // InternalTURN.g:2187:3: ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==44) ) {
                alt42=1;
            }
            else if ( (LA42_0==46) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalTURN.g:2188:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    {
                    // InternalTURN.g:2188:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    // InternalTURN.g:2189:5: otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_49); 

                    					newLeafNode(otherlv_2, grammarAccess.getEvaluationAccess().getEvaluationKeyword_2_0_0());
                    				
                    // InternalTURN.g:2193:5: ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=94 && LA41_0<=100)) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==RULE_INT||(LA41_0>=54 && LA41_0<=55)) ) {
                        alt41=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalTURN.g:2194:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            {
                            // InternalTURN.g:2194:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            // InternalTURN.g:2195:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            {
                            // InternalTURN.g:2195:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            // InternalTURN.g:2196:8: lv_qualitativeEvaluation_3_0= ruleQualitativeLabel
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_2_0_1_0_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_qualitativeEvaluation_3_0=ruleQualitativeLabel();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"qualitativeEvaluation",
                            									lv_qualitativeEvaluation_3_0,
                            									"org.xtext.example.mydsl.TURN.QualitativeLabel");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTURN.g:2214:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            {
                            // InternalTURN.g:2214:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            // InternalTURN.g:2215:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            {
                            // InternalTURN.g:2215:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            // InternalTURN.g:2216:8: lv_evaluation_4_0= ruleQuantitativeValue
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getEvaluationQuantitativeValueParserRuleCall_2_0_1_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_evaluation_4_0=ruleQuantitativeValue();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"evaluation",
                            									lv_evaluation_4_0,
                            									"org.xtext.example.mydsl.TURN.QuantitativeValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:2236:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalTURN.g:2236:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    // InternalTURN.g:2237:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalTURN.g:2237:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) )
                    // InternalTURN.g:2238:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    {
                    // InternalTURN.g:2238:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    // InternalTURN.g:2239:7: lv_indicatorEval_5_0= ruleIndicatorEvaluation
                    {

                    							newCompositeNode(grammarAccess.getEvaluationAccess().getIndicatorEvalIndicatorEvaluationParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_50);
                    lv_indicatorEval_5_0=ruleIndicatorEvaluation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEvaluationRule());
                    							}
                    							set(
                    								current,
                    								"indicatorEval",
                    								lv_indicatorEval_5_0,
                    								"org.xtext.example.mydsl.TURN.IndicatorEvaluation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,45,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getEvaluationAccess().getConvertedWithKeyword_2_1_1());
                    				
                    // InternalTURN.g:2260:5: ( (otherlv_7= RULE_ID ) )
                    // InternalTURN.g:2261:6: (otherlv_7= RULE_ID )
                    {
                    // InternalTURN.g:2261:6: (otherlv_7= RULE_ID )
                    // InternalTURN.g:2262:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEvaluationRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_7, grammarAccess.getEvaluationAccess().getConversionIndicatorConversionCrossReference_2_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleIndicatorEvaluation"
    // InternalTURN.g:2279:1: entryRuleIndicatorEvaluation returns [EObject current=null] : iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF ;
    public final EObject entryRuleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorEvaluation = null;


        try {
            // InternalTURN.g:2279:60: (iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF )
            // InternalTURN.g:2280:2: iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF
            {
             newCompositeNode(grammarAccess.getIndicatorEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorEvaluation=ruleIndicatorEvaluation();

            state._fsp--;

             current =iv_ruleIndicatorEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorEvaluation"


    // $ANTLR start "ruleIndicatorEvaluation"
    // InternalTURN.g:2286:1: ruleIndicatorEvaluation returns [EObject current=null] : (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) ;
    public final EObject ruleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_realWorldLabel_1_0=null;
        Token lv_realWorldValue_2_0=null;


        	enterRule();

        try {
            // InternalTURN.g:2292:2: ( (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) )
            // InternalTURN.g:2293:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            {
            // InternalTURN.g:2293:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            // InternalTURN.g:2294:3: otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getIndicatorEvaluationAccess().getRealKeyword_0());
            		
            // InternalTURN.g:2298:3: ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_STRING) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_INT) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalTURN.g:2299:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    {
                    // InternalTURN.g:2299:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    // InternalTURN.g:2300:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    {
                    // InternalTURN.g:2300:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    // InternalTURN.g:2301:6: lv_realWorldLabel_1_0= RULE_STRING
                    {
                    lv_realWorldLabel_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_realWorldLabel_1_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldLabelSTRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldLabel",
                    							lv_realWorldLabel_1_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:2318:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    {
                    // InternalTURN.g:2318:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    // InternalTURN.g:2319:5: (lv_realWorldValue_2_0= RULE_INT )
                    {
                    // InternalTURN.g:2319:5: (lv_realWorldValue_2_0= RULE_INT )
                    // InternalTURN.g:2320:6: lv_realWorldValue_2_0= RULE_INT
                    {
                    lv_realWorldValue_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_realWorldValue_2_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldValueINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldValue",
                    							lv_realWorldValue_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorEvaluation"


    // $ANTLR start "entryRuleIndicatorConversion"
    // InternalTURN.g:2341:1: entryRuleIndicatorConversion returns [EObject current=null] : iv_ruleIndicatorConversion= ruleIndicatorConversion EOF ;
    public final EObject entryRuleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorConversion = null;


        try {
            // InternalTURN.g:2341:60: (iv_ruleIndicatorConversion= ruleIndicatorConversion EOF )
            // InternalTURN.g:2342:2: iv_ruleIndicatorConversion= ruleIndicatorConversion EOF
            {
             newCompositeNode(grammarAccess.getIndicatorConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorConversion=ruleIndicatorConversion();

            state._fsp--;

             current =iv_ruleIndicatorConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorConversion"


    // $ANTLR start "ruleIndicatorConversion"
    // InternalTURN.g:2348:1: ruleIndicatorConversion returns [EObject current=null] : (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) ;
    public final EObject ruleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject this_LinearConversion_0 = null;

        EObject this_QualToQMappings_1 = null;



        	enterRule();

        try {
            // InternalTURN.g:2354:2: ( (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) )
            // InternalTURN.g:2355:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            {
            // InternalTURN.g:2355:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==47) ) {
                alt44=1;
            }
            else if ( (LA44_0==51) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalTURN.g:2356:3: this_LinearConversion_0= ruleLinearConversion
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getLinearConversionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LinearConversion_0=ruleLinearConversion();

                    state._fsp--;


                    			current = this_LinearConversion_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:2365:3: this_QualToQMappings_1= ruleQualToQMappings
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getQualToQMappingsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QualToQMappings_1=ruleQualToQMappings();

                    state._fsp--;


                    			current = this_QualToQMappings_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorConversion"


    // $ANTLR start "entryRuleLinearConversion"
    // InternalTURN.g:2377:1: entryRuleLinearConversion returns [EObject current=null] : iv_ruleLinearConversion= ruleLinearConversion EOF ;
    public final EObject entryRuleLinearConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinearConversion = null;


        try {
            // InternalTURN.g:2377:57: (iv_ruleLinearConversion= ruleLinearConversion EOF )
            // InternalTURN.g:2378:2: iv_ruleLinearConversion= ruleLinearConversion EOF
            {
             newCompositeNode(grammarAccess.getLinearConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLinearConversion=ruleLinearConversion();

            state._fsp--;

             current =iv_ruleLinearConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinearConversion"


    // $ANTLR start "ruleLinearConversion"
    // InternalTURN.g:2384:1: ruleLinearConversion returns [EObject current=null] : (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) ;
    public final EObject ruleLinearConversion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_6=null;
        Token lv_targetValue_7_0=null;
        Token otherlv_8=null;
        Token lv_thresholdValue_9_0=null;
        Token otherlv_10=null;
        Token lv_worstValue_11_0=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2390:2: ( (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) )
            // InternalTURN.g:2391:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            {
            // InternalTURN.g:2391:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            // InternalTURN.g:2392:3: otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinearConversionAccess().getLinearConversionKeyword_0());
            		
            // InternalTURN.g:2396:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:2397:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:2397:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:2398:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2415:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:2416:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:2416:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:2417:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getLinearConversionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getLinearConversionAccess().getUnitKeyword_4());
            		
            // InternalTURN.g:2442:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTURN.g:2443:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTURN.g:2443:4: (lv_unit_5_0= RULE_STRING )
            // InternalTURN.g:2444:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getLinearConversionAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,48,FOLLOW_54); 

            			newLeafNode(otherlv_6, grammarAccess.getLinearConversionAccess().getTargetKeyword_6());
            		
            // InternalTURN.g:2464:3: ( (lv_targetValue_7_0= RULE_INT ) )
            // InternalTURN.g:2465:4: (lv_targetValue_7_0= RULE_INT )
            {
            // InternalTURN.g:2465:4: (lv_targetValue_7_0= RULE_INT )
            // InternalTURN.g:2466:5: lv_targetValue_7_0= RULE_INT
            {
            lv_targetValue_7_0=(Token)match(input,RULE_INT,FOLLOW_55); 

            					newLeafNode(lv_targetValue_7_0, grammarAccess.getLinearConversionAccess().getTargetValueINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"targetValue",
            						lv_targetValue_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,49,FOLLOW_54); 

            			newLeafNode(otherlv_8, grammarAccess.getLinearConversionAccess().getThresholdKeyword_8());
            		
            // InternalTURN.g:2486:3: ( (lv_thresholdValue_9_0= RULE_INT ) )
            // InternalTURN.g:2487:4: (lv_thresholdValue_9_0= RULE_INT )
            {
            // InternalTURN.g:2487:4: (lv_thresholdValue_9_0= RULE_INT )
            // InternalTURN.g:2488:5: lv_thresholdValue_9_0= RULE_INT
            {
            lv_thresholdValue_9_0=(Token)match(input,RULE_INT,FOLLOW_56); 

            					newLeafNode(lv_thresholdValue_9_0, grammarAccess.getLinearConversionAccess().getThresholdValueINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"thresholdValue",
            						lv_thresholdValue_9_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_10=(Token)match(input,50,FOLLOW_54); 

            			newLeafNode(otherlv_10, grammarAccess.getLinearConversionAccess().getWorstKeyword_10());
            		
            // InternalTURN.g:2508:3: ( (lv_worstValue_11_0= RULE_INT ) )
            // InternalTURN.g:2509:4: (lv_worstValue_11_0= RULE_INT )
            {
            // InternalTURN.g:2509:4: (lv_worstValue_11_0= RULE_INT )
            // InternalTURN.g:2510:5: lv_worstValue_11_0= RULE_INT
            {
            lv_worstValue_11_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_worstValue_11_0, grammarAccess.getLinearConversionAccess().getWorstValueINTTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"worstValue",
            						lv_worstValue_11_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLinearConversionAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinearConversion"


    // $ANTLR start "entryRuleQualToQMappings"
    // InternalTURN.g:2534:1: entryRuleQualToQMappings returns [EObject current=null] : iv_ruleQualToQMappings= ruleQualToQMappings EOF ;
    public final EObject entryRuleQualToQMappings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMappings = null;


        try {
            // InternalTURN.g:2534:56: (iv_ruleQualToQMappings= ruleQualToQMappings EOF )
            // InternalTURN.g:2535:2: iv_ruleQualToQMappings= ruleQualToQMappings EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMappings=ruleQualToQMappings();

            state._fsp--;

             current =iv_ruleQualToQMappings; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMappings"


    // $ANTLR start "ruleQualToQMappings"
    // InternalTURN.g:2541:1: ruleQualToQMappings returns [EObject current=null] : (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) ;
    public final EObject ruleQualToQMappings() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_mappings_6_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2547:2: ( (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) )
            // InternalTURN.g:2548:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            {
            // InternalTURN.g:2548:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            // InternalTURN.g:2549:3: otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getQualToQMappingsAccess().getMappingConversionKeyword_0());
            		
            // InternalTURN.g:2553:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:2554:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:2554:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:2555:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2572:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:2573:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:2573:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:2574:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingsAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getQualToQMappingsAccess().getUnitKeyword_4());
            		
            // InternalTURN.g:2599:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTURN.g:2600:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTURN.g:2600:4: (lv_unit_5_0= RULE_STRING )
            // InternalTURN.g:2601:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_57); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getQualToQMappingsAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTURN.g:2617:3: ( (lv_mappings_6_0= ruleQualToQMapping ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==43||LA45_0==46) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalTURN.g:2618:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    {
            	    // InternalTURN.g:2618:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    // InternalTURN.g:2619:5: lv_mappings_6_0= ruleQualToQMapping
            	    {

            	    					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getMappingsQualToQMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_58);
            	    lv_mappings_6_0=ruleQualToQMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mappings",
            	    						lv_mappings_6_0,
            	    						"org.xtext.example.mydsl.TURN.QualToQMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getQualToQMappingsAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMappings"


    // $ANTLR start "entryRuleQualToQMapping"
    // InternalTURN.g:2644:1: entryRuleQualToQMapping returns [EObject current=null] : iv_ruleQualToQMapping= ruleQualToQMapping EOF ;
    public final EObject entryRuleQualToQMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMapping = null;


        try {
            // InternalTURN.g:2644:55: (iv_ruleQualToQMapping= ruleQualToQMapping EOF )
            // InternalTURN.g:2645:2: iv_ruleQualToQMapping= ruleQualToQMapping EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMapping=ruleQualToQMapping();

            state._fsp--;

             current =iv_ruleQualToQMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMapping"


    // $ANTLR start "ruleQualToQMapping"
    // InternalTURN.g:2651:1: ruleQualToQMapping returns [EObject current=null] : ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleQualToQMapping() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_0_0=null;
        Token otherlv_1=null;
        Token lv_realWorldLabel_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_qualitativeEvaluation_4_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_5_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2657:2: ( ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTURN.g:2658:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTURN.g:2658:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            // InternalTURN.g:2659:3: ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            {
            // InternalTURN.g:2659:3: ( (lv_exceeds_0_0= 'exceeding' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==43) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalTURN.g:2660:4: (lv_exceeds_0_0= 'exceeding' )
                    {
                    // InternalTURN.g:2660:4: (lv_exceeds_0_0= 'exceeding' )
                    // InternalTURN.g:2661:5: lv_exceeds_0_0= 'exceeding'
                    {
                    lv_exceeds_0_0=(Token)match(input,43,FOLLOW_59); 

                    					newLeafNode(lv_exceeds_0_0, grammarAccess.getQualToQMappingAccess().getExceedsExceedingKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQualToQMappingRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,46,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getQualToQMappingAccess().getRealKeyword_1());
            		
            // InternalTURN.g:2677:3: ( (lv_realWorldLabel_2_0= RULE_STRING ) )
            // InternalTURN.g:2678:4: (lv_realWorldLabel_2_0= RULE_STRING )
            {
            // InternalTURN.g:2678:4: (lv_realWorldLabel_2_0= RULE_STRING )
            // InternalTURN.g:2679:5: lv_realWorldLabel_2_0= RULE_STRING
            {
            lv_realWorldLabel_2_0=(Token)match(input,RULE_STRING,FOLLOW_26); 

            					newLeafNode(lv_realWorldLabel_2_0, grammarAccess.getQualToQMappingAccess().getRealWorldLabelSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"realWorldLabel",
            						lv_realWorldLabel_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalTURN.g:2699:3: ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=94 && LA47_0<=100)) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_INT||(LA47_0>=54 && LA47_0<=55)) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalTURN.g:2700:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    {
                    // InternalTURN.g:2700:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    // InternalTURN.g:2701:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    {
                    // InternalTURN.g:2701:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    // InternalTURN.g:2702:6: lv_qualitativeEvaluation_4_0= ruleQualitativeLabel
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_qualitativeEvaluation_4_0=ruleQualitativeLabel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"qualitativeEvaluation",
                    							lv_qualitativeEvaluation_4_0,
                    							"org.xtext.example.mydsl.TURN.QualitativeLabel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:2720:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    {
                    // InternalTURN.g:2720:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    // InternalTURN.g:2721:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    {
                    // InternalTURN.g:2721:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    // InternalTURN.g:2722:6: lv_evaluation_5_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getEvaluationQuantitativeValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_evaluation_5_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"evaluation",
                    							lv_evaluation_5_0,
                    							"org.xtext.example.mydsl.TURN.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMapping"


    // $ANTLR start "entryRuleContributionContextGroup"
    // InternalTURN.g:2744:1: entryRuleContributionContextGroup returns [EObject current=null] : iv_ruleContributionContextGroup= ruleContributionContextGroup EOF ;
    public final EObject entryRuleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContextGroup = null;


        try {
            // InternalTURN.g:2744:65: (iv_ruleContributionContextGroup= ruleContributionContextGroup EOF )
            // InternalTURN.g:2745:2: iv_ruleContributionContextGroup= ruleContributionContextGroup EOF
            {
             newCompositeNode(grammarAccess.getContributionContextGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContextGroup=ruleContributionContextGroup();

            state._fsp--;

             current =iv_ruleContributionContextGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContextGroup"


    // $ANTLR start "ruleContributionContextGroup"
    // InternalTURN.g:2751:1: ruleContributionContextGroup returns [EObject current=null] : (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2757:2: ( (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTURN.g:2758:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTURN.g:2758:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTURN.g:2759:3: otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextGroupAccess().getContributionContextGroupKeyword_0());
            		
            // InternalTURN.g:2763:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:2764:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:2764:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:2765:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2782:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:2783:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:2783:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:2784:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextGroupAccess().getColonKeyword_3());
            		
            // InternalTURN.g:2805:3: ( (otherlv_4= RULE_ID ) )
            // InternalTURN.g:2806:4: (otherlv_4= RULE_ID )
            {
            // InternalTURN.g:2806:4: (otherlv_4= RULE_ID )
            // InternalTURN.g:2807:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionContextGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(otherlv_4, grammarAccess.getContributionContextGroupAccess().getContribContributionContextCrossReference_4_0());
            				

            }


            }

            // InternalTURN.g:2818:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==24) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalTURN.g:2819:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getContributionContextGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTURN.g:2823:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTURN.g:2824:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTURN.g:2824:5: (otherlv_6= RULE_ID )
            	    // InternalTURN.g:2825:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContributionContextGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_45); 

            	    						newLeafNode(otherlv_6, grammarAccess.getContributionContextGroupAccess().getContribsContributionContextCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContextGroup"


    // $ANTLR start "entryRuleContributionContext"
    // InternalTURN.g:2841:1: entryRuleContributionContext returns [EObject current=null] : iv_ruleContributionContext= ruleContributionContext EOF ;
    public final EObject entryRuleContributionContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContext = null;


        try {
            // InternalTURN.g:2841:60: (iv_ruleContributionContext= ruleContributionContext EOF )
            // InternalTURN.g:2842:2: iv_ruleContributionContext= ruleContributionContext EOF
            {
             newCompositeNode(grammarAccess.getContributionContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContext=ruleContributionContext();

            state._fsp--;

             current =iv_ruleContributionContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContext"


    // $ANTLR start "ruleContributionContext"
    // InternalTURN.g:2848:1: ruleContributionContext returns [EObject current=null] : (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' ) ;
    public final EObject ruleContributionContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_changes_4_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2854:2: ( (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' ) )
            // InternalTURN.g:2855:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' )
            {
            // InternalTURN.g:2855:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}' )
            // InternalTURN.g:2856:3: otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextAccess().getContributionContextKeyword_0());
            		
            // InternalTURN.g:2860:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:2861:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:2861:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:2862:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:2879:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:2880:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:2880:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:2881:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTURN.g:2902:3: ( (lv_changes_4_0= ruleContributionChange ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTURN.g:2903:4: (lv_changes_4_0= ruleContributionChange )
            	    {
            	    // InternalTURN.g:2903:4: (lv_changes_4_0= ruleContributionChange )
            	    // InternalTURN.g:2904:5: lv_changes_4_0= ruleContributionChange
            	    {

            	    					newCompositeNode(grammarAccess.getContributionContextAccess().getChangesContributionChangeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_47);
            	    lv_changes_4_0=ruleContributionChange();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"changes",
            	    						lv_changes_4_0,
            	    						"org.xtext.example.mydsl.TURN.ContributionChange");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            // InternalTURN.g:2921:3: (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==42) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalTURN.g:2922:4: otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) )*
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getContributionContextAccess().getIncludesKeyword_5_0());
                    			
                    // InternalTURN.g:2926:4: ( (otherlv_6= RULE_ID ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==RULE_ID) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalTURN.g:2927:5: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalTURN.g:2927:5: (otherlv_6= RULE_ID )
                    	    // InternalTURN.g:2928:6: otherlv_6= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getContributionContextRule());
                    	    						}
                    	    					
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_7); 

                    	    						newLeafNode(otherlv_6, grammarAccess.getContributionContextAccess().getIncludedContextsContributionContextCrossReference_5_1_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getContributionContextAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContext"


    // $ANTLR start "entryRuleContributionChange"
    // InternalTURN.g:2948:1: entryRuleContributionChange returns [EObject current=null] : iv_ruleContributionChange= ruleContributionChange EOF ;
    public final EObject entryRuleContributionChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionChange = null;


        try {
            // InternalTURN.g:2948:59: (iv_ruleContributionChange= ruleContributionChange EOF )
            // InternalTURN.g:2949:2: iv_ruleContributionChange= ruleContributionChange EOF
            {
             newCompositeNode(grammarAccess.getContributionChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionChange=ruleContributionChange();

            state._fsp--;

             current =iv_ruleContributionChange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionChange"


    // $ANTLR start "ruleContributionChange"
    // InternalTURN.g:2955:1: ruleContributionChange returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContributionChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_newContribution_2_0 = null;

        AntlrDatatypeRuleToken lv_newQuantitativeContribution_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:2961:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTURN.g:2962:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTURN.g:2962:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            // InternalTURN.g:2963:3: ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            {
            // InternalTURN.g:2963:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:2964:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:2964:4: ( ruleQualifiedName )
            // InternalTURN.g:2965:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionChangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionChangeAccess().getContributionContributionCrossReference_0_0());
            				
            pushFollow(FOLLOW_38);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getContributionChangeAccess().getWithKeyword_1());
            		
            // InternalTURN.g:2983:3: ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==99||(LA52_0>=107 && LA52_0<=113)) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_INT||(LA52_0>=54 && LA52_0<=55)) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalTURN.g:2984:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    {
                    // InternalTURN.g:2984:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    // InternalTURN.g:2985:5: (lv_newContribution_2_0= ruleContributionType )
                    {
                    // InternalTURN.g:2985:5: (lv_newContribution_2_0= ruleContributionType )
                    // InternalTURN.g:2986:6: lv_newContribution_2_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewContributionContributionTypeEnumRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newContribution_2_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newContribution",
                    							lv_newContribution_2_0,
                    							"org.xtext.example.mydsl.TURN.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:3004:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    {
                    // InternalTURN.g:3004:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    // InternalTURN.g:3005:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    {
                    // InternalTURN.g:3005:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    // InternalTURN.g:3006:6: lv_newQuantitativeContribution_3_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewQuantitativeContributionQuantitativeValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newQuantitativeContribution_3_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newQuantitativeContribution",
                    							lv_newQuantitativeContribution_3_0,
                    							"org.xtext.example.mydsl.TURN.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionChange"


    // $ANTLR start "entryRuleQuantitativeValue"
    // InternalTURN.g:3028:1: entryRuleQuantitativeValue returns [String current=null] : iv_ruleQuantitativeValue= ruleQuantitativeValue EOF ;
    public final String entryRuleQuantitativeValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQuantitativeValue = null;


        try {
            // InternalTURN.g:3028:57: (iv_ruleQuantitativeValue= ruleQuantitativeValue EOF )
            // InternalTURN.g:3029:2: iv_ruleQuantitativeValue= ruleQuantitativeValue EOF
            {
             newCompositeNode(grammarAccess.getQuantitativeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantitativeValue=ruleQuantitativeValue();

            state._fsp--;

             current =iv_ruleQuantitativeValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantitativeValue"


    // $ANTLR start "ruleQuantitativeValue"
    // InternalTURN.g:3035:1: ruleQuantitativeValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleQuantitativeValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalTURN.g:3041:2: ( ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) )
            // InternalTURN.g:3042:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            {
            // InternalTURN.g:3042:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            // InternalTURN.g:3043:3: (kw= '-' | kw= '+' )? this_INT_2= RULE_INT
            {
            // InternalTURN.g:3043:3: (kw= '-' | kw= '+' )?
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==54) ) {
                alt53=1;
            }
            else if ( (LA53_0==55) ) {
                alt53=2;
            }
            switch (alt53) {
                case 1 :
                    // InternalTURN.g:3044:4: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTURN.g:3050:4: kw= '+'
                    {
                    kw=(Token)match(input,55,FOLLOW_54); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getPlusSignKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getQuantitativeValueAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantitativeValue"


    // $ANTLR start "entryRuleUCMmap"
    // InternalTURN.g:3067:1: entryRuleUCMmap returns [EObject current=null] : iv_ruleUCMmap= ruleUCMmap EOF ;
    public final EObject entryRuleUCMmap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCMmap = null;


        try {
            // InternalTURN.g:3067:47: (iv_ruleUCMmap= ruleUCMmap EOF )
            // InternalTURN.g:3068:2: iv_ruleUCMmap= ruleUCMmap EOF
            {
             newCompositeNode(grammarAccess.getUCMmapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCMmap=ruleUCMmap();

            state._fsp--;

             current =iv_ruleUCMmap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCMmap"


    // $ANTLR start "ruleUCMmap"
    // InternalTURN.g:3074:1: ruleUCMmap returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) ;
    public final EObject ruleUCMmap() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_stubs_5_0 = null;

        EObject lv_paths_6_0 = null;

        EObject lv_components_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3080:2: ( ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) )
            // InternalTURN.g:3081:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            {
            // InternalTURN.g:3081:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            // InternalTURN.g:3082:3: ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}'
            {
            // InternalTURN.g:3082:3: ( (lv_singleton_0_0= 'singleton' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==56) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalTURN.g:3083:4: (lv_singleton_0_0= 'singleton' )
                    {
                    // InternalTURN.g:3083:4: (lv_singleton_0_0= 'singleton' )
                    // InternalTURN.g:3084:5: lv_singleton_0_0= 'singleton'
                    {
                    lv_singleton_0_0=(Token)match(input,56,FOLLOW_60); 

                    					newLeafNode(lv_singleton_0_0, grammarAccess.getUCMmapAccess().getSingletonSingletonKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUCMmapRule());
                    					}
                    					setWithLastConsumed(current, "singleton", true, "singleton");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUCMmapAccess().getMapKeyword_1());
            		
            // InternalTURN.g:3100:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTURN.g:3101:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTURN.g:3101:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTURN.g:3102:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:3119:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTURN.g:3120:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTURN.g:3120:4: (lv_longName_3_0= ruleLongName )
            // InternalTURN.g:3121:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_61); 

            			newLeafNode(otherlv_4, grammarAccess.getUCMmapAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTURN.g:3142:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*
            loop55:
            do {
                int alt55=2;
                alt55 = dfa55.predict(input);
                switch (alt55) {
            	case 1 :
            	    // InternalTURN.g:3143:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    {
            	    // InternalTURN.g:3143:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    // InternalTURN.g:3144:5: lv_stubs_5_0= ruleStubDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getStubsStubDeclarationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_stubs_5_0=ruleStubDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stubs",
            	    						lv_stubs_5_0,
            	    						"org.xtext.example.mydsl.TURN.StubDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // InternalTURN.g:3161:3: ( (lv_paths_6_0= rulePath ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==58||(LA56_0>=60 && LA56_0<=61)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalTURN.g:3162:4: (lv_paths_6_0= rulePath )
            	    {
            	    // InternalTURN.g:3162:4: (lv_paths_6_0= rulePath )
            	    // InternalTURN.g:3163:5: lv_paths_6_0= rulePath
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getPathsPathParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_61);
            	    lv_paths_6_0=rulePath();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"paths",
            	    						lv_paths_6_0,
            	    						"org.xtext.example.mydsl.TURN.Path");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // InternalTURN.g:3180:3: ( (lv_components_7_0= ruleComponentRef ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID||LA57_0==32||LA57_0==86||(LA57_0>=122 && LA57_0<=126)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalTURN.g:3181:4: (lv_components_7_0= ruleComponentRef )
            	    {
            	    // InternalTURN.g:3181:4: (lv_components_7_0= ruleComponentRef )
            	    // InternalTURN.g:3182:5: lv_components_7_0= ruleComponentRef
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getComponentsComponentRefParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_62);
            	    lv_components_7_0=ruleComponentRef();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_7_0,
            	    						"org.xtext.example.mydsl.TURN.ComponentRef");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getUCMmapAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCMmap"


    // $ANTLR start "entryRulePath"
    // InternalTURN.g:3207:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalTURN.g:3207:45: (iv_rulePath= rulePath EOF )
            // InternalTURN.g:3208:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalTURN.g:3214:1: rulePath returns [EObject current=null] : ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        EObject lv_startPoint_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3220:2: ( ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTURN.g:3221:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTURN.g:3221:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTURN.g:3222:3: ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTURN.g:3222:3: ( (lv_startPoint_0_0= ruleStartPoint ) )
            // InternalTURN.g:3223:4: (lv_startPoint_0_0= ruleStartPoint )
            {
            // InternalTURN.g:3223:4: (lv_startPoint_0_0= ruleStartPoint )
            // InternalTURN.g:3224:5: lv_startPoint_0_0= ruleStartPoint
            {

            					newCompositeNode(grammarAccess.getPathAccess().getStartPointStartPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
            lv_startPoint_0_0=ruleStartPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"startPoint",
            						lv_startPoint_0_0,
            						"org.xtext.example.mydsl.TURN.StartPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:3241:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTURN.g:3242:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTURN.g:3242:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTURN.g:3243:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getPathAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.xtext.example.mydsl.TURN.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleStartPoint"
    // InternalTURN.g:3264:1: entryRuleStartPoint returns [EObject current=null] : iv_ruleStartPoint= ruleStartPoint EOF ;
    public final EObject entryRuleStartPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartPoint = null;


        try {
            // InternalTURN.g:3264:51: (iv_ruleStartPoint= ruleStartPoint EOF )
            // InternalTURN.g:3265:2: iv_ruleStartPoint= ruleStartPoint EOF
            {
             newCompositeNode(grammarAccess.getStartPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartPoint=ruleStartPoint();

            state._fsp--;

             current =iv_ruleStartPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartPoint"


    // $ANTLR start "ruleStartPoint"
    // InternalTURN.g:3271:1: ruleStartPoint returns [EObject current=null] : ( ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) ) ( (lv_precondition_8_0= ruleCondition ) )? ) ;
    public final EObject ruleStartPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token lv_catches_7_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        AntlrDatatypeRuleToken lv_failKind_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_longName_5_0 = null;

        EObject lv_precondition_8_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3277:2: ( ( ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) ) ( (lv_precondition_8_0= ruleCondition ) )? ) )
            // InternalTURN.g:3278:2: ( ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) ) ( (lv_precondition_8_0= ruleCondition ) )? )
            {
            // InternalTURN.g:3278:2: ( ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) ) ( (lv_precondition_8_0= ruleCondition ) )? )
            // InternalTURN.g:3279:3: ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) ) ( (lv_precondition_8_0= ruleCondition ) )?
            {
            // InternalTURN.g:3279:3: ( (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) | ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==58) ) {
                alt59=1;
            }
            else if ( ((LA59_0>=60 && LA59_0<=61)) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalTURN.g:3280:4: (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
                    {
                    // InternalTURN.g:3280:4: (otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
                    // InternalTURN.g:3281:5: otherlv_0= 'start' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_3); 

                    					newLeafNode(otherlv_0, grammarAccess.getStartPointAccess().getStartKeyword_0_0_0());
                    				
                    // InternalTURN.g:3285:5: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTURN.g:3286:6: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:3286:6: (lv_name_1_0= ruleQualifiedName )
                    // InternalTURN.g:3287:7: lv_name_1_0= ruleQualifiedName
                    {

                    							newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_0_0_1_0());
                    						
                    pushFollow(FOLLOW_64);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStartPointRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"org.xtext.example.mydsl.TURN.QualifiedName");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:3304:5: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTURN.g:3305:6: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTURN.g:3305:6: (lv_longName_2_0= ruleLongName )
                    // InternalTURN.g:3306:7: lv_longName_2_0= ruleLongName
                    {

                    							newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_0_0_2_0());
                    						
                    pushFollow(FOLLOW_65);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStartPointRule());
                    							}
                    							set(
                    								current,
                    								"longName",
                    								lv_longName_2_0,
                    								"org.xtext.example.mydsl.TURN.LongName");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:3325:4: ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? )
                    {
                    // InternalTURN.g:3325:4: ( ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )? )
                    // InternalTURN.g:3326:5: ( (lv_failKind_3_0= ruleFailureKind ) ) ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )?
                    {
                    // InternalTURN.g:3326:5: ( (lv_failKind_3_0= ruleFailureKind ) )
                    // InternalTURN.g:3327:6: (lv_failKind_3_0= ruleFailureKind )
                    {
                    // InternalTURN.g:3327:6: (lv_failKind_3_0= ruleFailureKind )
                    // InternalTURN.g:3328:7: lv_failKind_3_0= ruleFailureKind
                    {

                    							newCompositeNode(grammarAccess.getStartPointAccess().getFailKindFailureKindParserRuleCall_0_1_0_0());
                    						
                    pushFollow(FOLLOW_3);
                    lv_failKind_3_0=ruleFailureKind();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStartPointRule());
                    							}
                    							set(
                    								current,
                    								"failKind",
                    								lv_failKind_3_0,
                    								"org.xtext.example.mydsl.TURN.FailureKind");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:3345:5: ( (lv_name_4_0= ruleQualifiedName ) )
                    // InternalTURN.g:3346:6: (lv_name_4_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:3346:6: (lv_name_4_0= ruleQualifiedName )
                    // InternalTURN.g:3347:7: lv_name_4_0= ruleQualifiedName
                    {

                    							newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_0_1_1_0());
                    						
                    pushFollow(FOLLOW_66);
                    lv_name_4_0=ruleQualifiedName();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStartPointRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_4_0,
                    								"org.xtext.example.mydsl.TURN.QualifiedName");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:3364:5: ( (lv_longName_5_0= ruleLongName ) )
                    // InternalTURN.g:3365:6: (lv_longName_5_0= ruleLongName )
                    {
                    // InternalTURN.g:3365:6: (lv_longName_5_0= ruleLongName )
                    // InternalTURN.g:3366:7: lv_longName_5_0= ruleLongName
                    {

                    							newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_0_1_2_0());
                    						
                    pushFollow(FOLLOW_67);
                    lv_longName_5_0=ruleLongName();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStartPointRule());
                    							}
                    							set(
                    								current,
                    								"longName",
                    								lv_longName_5_0,
                    								"org.xtext.example.mydsl.TURN.LongName");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:3383:5: (otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==59) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalTURN.g:3384:6: otherlv_6= 'catches' ( (lv_catches_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,59,FOLLOW_9); 

                            						newLeafNode(otherlv_6, grammarAccess.getStartPointAccess().getCatchesKeyword_0_1_3_0());
                            					
                            // InternalTURN.g:3388:6: ( (lv_catches_7_0= RULE_STRING ) )
                            // InternalTURN.g:3389:7: (lv_catches_7_0= RULE_STRING )
                            {
                            // InternalTURN.g:3389:7: (lv_catches_7_0= RULE_STRING )
                            // InternalTURN.g:3390:8: lv_catches_7_0= RULE_STRING
                            {
                            lv_catches_7_0=(Token)match(input,RULE_STRING,FOLLOW_65); 

                            								newLeafNode(lv_catches_7_0, grammarAccess.getStartPointAccess().getCatchesSTRINGTerminalRuleCall_0_1_3_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getStartPointRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"catches",
                            									lv_catches_7_0,
                            									"org.eclipse.xtext.common.Terminals.STRING");
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:3409:3: ( (lv_precondition_8_0= ruleCondition ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==26) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalTURN.g:3410:4: (lv_precondition_8_0= ruleCondition )
                    {
                    // InternalTURN.g:3410:4: (lv_precondition_8_0= ruleCondition )
                    // InternalTURN.g:3411:5: lv_precondition_8_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getStartPointAccess().getPreconditionConditionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_precondition_8_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStartPointRule());
                    					}
                    					set(
                    						current,
                    						"precondition",
                    						lv_precondition_8_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartPoint"


    // $ANTLR start "entryRuleFailureKind"
    // InternalTURN.g:3432:1: entryRuleFailureKind returns [String current=null] : iv_ruleFailureKind= ruleFailureKind EOF ;
    public final String entryRuleFailureKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFailureKind = null;


        try {
            // InternalTURN.g:3432:51: (iv_ruleFailureKind= ruleFailureKind EOF )
            // InternalTURN.g:3433:2: iv_ruleFailureKind= ruleFailureKind EOF
            {
             newCompositeNode(grammarAccess.getFailureKindRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailureKind=ruleFailureKind();

            state._fsp--;

             current =iv_ruleFailureKind.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureKind"


    // $ANTLR start "ruleFailureKind"
    // InternalTURN.g:3439:1: ruleFailureKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abort' | kw= 'failure' ) ;
    public final AntlrDatatypeRuleToken ruleFailureKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTURN.g:3445:2: ( (kw= 'abort' | kw= 'failure' ) )
            // InternalTURN.g:3446:2: (kw= 'abort' | kw= 'failure' )
            {
            // InternalTURN.g:3446:2: (kw= 'abort' | kw= 'failure' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                alt61=1;
            }
            else if ( (LA61_0==61) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalTURN.g:3447:3: kw= 'abort'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFailureKindAccess().getAbortKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:3453:3: kw= 'failure'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFailureKindAccess().getFailureKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureKind"


    // $ANTLR start "entryRulePathBody"
    // InternalTURN.g:3462:1: entryRulePathBody returns [EObject current=null] : iv_rulePathBody= rulePathBody EOF ;
    public final EObject entryRulePathBody() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBody = null;


        try {
            // InternalTURN.g:3462:49: (iv_rulePathBody= rulePathBody EOF )
            // InternalTURN.g:3463:2: iv_rulePathBody= rulePathBody EOF
            {
             newCompositeNode(grammarAccess.getPathBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBody=rulePathBody();

            state._fsp--;

             current =iv_rulePathBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBody"


    // $ANTLR start "rulePathBody"
    // InternalTURN.g:3469:1: rulePathBody returns [EObject current=null] : this_PathWithRegularEnd_0= rulePathWithRegularEnd ;
    public final EObject rulePathBody() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithRegularEnd_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3475:2: (this_PathWithRegularEnd_0= rulePathWithRegularEnd )
            // InternalTURN.g:3476:2: this_PathWithRegularEnd_0= rulePathWithRegularEnd
            {

            		newCompositeNode(grammarAccess.getPathBodyAccess().getPathWithRegularEndParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_PathWithRegularEnd_0=rulePathWithRegularEnd();

            state._fsp--;


            		current = this_PathWithRegularEnd_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBody"


    // $ANTLR start "entryRulePathWithRegularEnd"
    // InternalTURN.g:3487:1: entryRulePathWithRegularEnd returns [EObject current=null] : iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF ;
    public final EObject entryRulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithRegularEnd = null;


        try {
            // InternalTURN.g:3487:59: (iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF )
            // InternalTURN.g:3488:2: iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithRegularEnd=rulePathWithRegularEnd();

            state._fsp--;

             current =iv_rulePathWithRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithRegularEnd"


    // $ANTLR start "rulePathWithRegularEnd"
    // InternalTURN.g:3494:1: rulePathWithRegularEnd returns [EObject current=null] : (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) ;
    public final EObject rulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithReferencedEnd_0 = null;

        EObject lv_pathEnd_1_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3500:2: ( (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) )
            // InternalTURN.g:3501:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            {
            // InternalTURN.g:3501:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            // InternalTURN.g:3502:3: this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            {

            			newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathWithReferencedEndParserRuleCall_0());
            		
            pushFollow(FOLLOW_68);
            this_PathWithReferencedEnd_0=rulePathWithReferencedEnd();

            state._fsp--;


            			current = this_PathWithReferencedEnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTURN.g:3510:3: ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==75||LA62_0==77||LA62_0==79||LA62_0==81||(LA62_0>=120 && LA62_0<=121)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalTURN.g:3511:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    {
                    // InternalTURN.g:3511:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    // InternalTURN.g:3512:5: lv_pathEnd_1_0= ruleRegularEnd
                    {

                    					newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathEndRegularEndParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pathEnd_1_0=ruleRegularEnd();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPathWithRegularEndRule());
                    					}
                    					set(
                    						current,
                    						"pathEnd",
                    						lv_pathEnd_1_0,
                    						"org.xtext.example.mydsl.TURN.RegularEnd");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithRegularEnd"


    // $ANTLR start "entryRulePathWithReferencedEnd"
    // InternalTURN.g:3533:1: entryRulePathWithReferencedEnd returns [EObject current=null] : iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF ;
    public final EObject entryRulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedEnd = null;


        try {
            // InternalTURN.g:3533:62: (iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF )
            // InternalTURN.g:3534:2: iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedEnd=rulePathWithReferencedEnd();

            state._fsp--;

             current =iv_rulePathWithReferencedEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedEnd"


    // $ANTLR start "rulePathWithReferencedEnd"
    // InternalTURN.g:3540:1: rulePathWithReferencedEnd returns [EObject current=null] : (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) ;
    public final EObject rulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PathWithReferencedStub_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3546:2: ( (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) )
            // InternalTURN.g:3547:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            {
            // InternalTURN.g:3547:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            // InternalTURN.g:3548:3: this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedEndAccess().getPathWithReferencedStubParserRuleCall_0());
            		
            pushFollow(FOLLOW_69);
            this_PathWithReferencedStub_0=rulePathWithReferencedStub();

            state._fsp--;


            			current = this_PathWithReferencedStub_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTURN.g:3556:3: ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==62) ) {
                    alt64=1;
                }
            }
            else if ( (LA64_0==62) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalTURN.g:3557:4: ( (otherlv_1= RULE_ID ) )? otherlv_2= ';'
                    {
                    // InternalTURN.g:3557:4: ( (otherlv_1= RULE_ID ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalTURN.g:3558:5: (otherlv_1= RULE_ID )
                            {
                            // InternalTURN.g:3558:5: (otherlv_1= RULE_ID )
                            // InternalTURN.g:3559:6: otherlv_1= RULE_ID
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPathWithReferencedEndRule());
                            						}
                            					
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_70); 

                            						newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedEndAccess().getReferencedEndReferencedEndCrossReference_1_0_0());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPathWithReferencedEndAccess().getSemicolonKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedEnd"


    // $ANTLR start "entryRulePathWithReferencedStub"
    // InternalTURN.g:3579:1: entryRulePathWithReferencedStub returns [EObject current=null] : iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF ;
    public final EObject entryRulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedStub = null;


        try {
            // InternalTURN.g:3579:63: (iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF )
            // InternalTURN.g:3580:2: iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedStubRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedStub=rulePathWithReferencedStub();

            state._fsp--;

             current =iv_rulePathWithReferencedStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedStub"


    // $ANTLR start "rulePathWithReferencedStub"
    // InternalTURN.g:3586:1: rulePathWithReferencedStub returns [EObject current=null] : (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) ;
    public final EObject rulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PathBodyNodes_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3592:2: ( (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) )
            // InternalTURN.g:3593:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            {
            // InternalTURN.g:3593:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            // InternalTURN.g:3594:3: this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getPathBodyNodesParserRuleCall_0());
            		
            pushFollow(FOLLOW_71);
            this_PathBodyNodes_0=rulePathBodyNodes();

            state._fsp--;


            			current = this_PathBodyNodes_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTURN.g:3602:3: (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==63) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalTURN.g:3603:4: otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,63,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedStubAccess().getInKeyword_1_0());
                    			
                    // InternalTURN.g:3607:4: ( ( ruleQualifiedName ) )
                    // InternalTURN.g:3608:5: ( ruleQualifiedName )
                    {
                    // InternalTURN.g:3608:5: ( ruleQualifiedName )
                    // InternalTURN.g:3609:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getReferencedStubStubCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_54);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:3623:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTURN.g:3624:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTURN.g:3624:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTURN.g:3625:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getIndexPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_70);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.xtext.example.mydsl.TURN.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPathWithReferencedStubAccess().getSemicolonKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedStub"


    // $ANTLR start "entryRulePathBodyNodes"
    // InternalTURN.g:3651:1: entryRulePathBodyNodes returns [EObject current=null] : iv_rulePathBodyNodes= rulePathBodyNodes EOF ;
    public final EObject entryRulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNodes = null;


        try {
            // InternalTURN.g:3651:54: (iv_rulePathBodyNodes= rulePathBodyNodes EOF )
            // InternalTURN.g:3652:2: iv_rulePathBodyNodes= rulePathBodyNodes EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNodes=rulePathBodyNodes();

            state._fsp--;

             current =iv_rulePathBodyNodes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNodes"


    // $ANTLR start "rulePathBodyNodes"
    // InternalTURN.g:3658:1: rulePathBodyNodes returns [EObject current=null] : ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) ;
    public final EObject rulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_pathNodes_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3664:2: ( ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) )
            // InternalTURN.g:3665:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            {
            // InternalTURN.g:3665:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            // InternalTURN.g:3666:3: () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            {
            // InternalTURN.g:3666:3: ()
            // InternalTURN.g:3667:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPathBodyNodesAccess().getPathBodyNodesAction_0(),
            					current);
            			

            }


            			newCompositeNode(grammarAccess.getPathBodyNodesAccess().getArrowParserRuleCall_1());
            		
            pushFollow(FOLLOW_72);
            ruleArrow();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalTURN.g:3680:3: ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=65 && LA66_0<=71)||(LA66_0>=73 && LA66_0<=74)||(LA66_0>=118 && LA66_0<=119)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalTURN.g:3681:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->'
            	    {
            	    // InternalTURN.g:3681:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) )
            	    // InternalTURN.g:3682:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    {
            	    // InternalTURN.g:3682:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    // InternalTURN.g:3683:6: lv_pathNodes_2_0= rulePathBodyNode
            	    {

            	    						newCompositeNode(grammarAccess.getPathBodyNodesAccess().getPathNodesPathBodyNodeParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
            	    lv_pathNodes_2_0=rulePathBodyNode();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPathBodyNodesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathNodes",
            	    							lv_pathNodes_2_0,
            	    							"org.xtext.example.mydsl.TURN.PathBodyNode");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,64,FOLLOW_72); 

            	    				newLeafNode(otherlv_3, grammarAccess.getPathBodyNodesAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNodes"


    // $ANTLR start "entryRuleArrow"
    // InternalTURN.g:3709:1: entryRuleArrow returns [String current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final String entryRuleArrow() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrow = null;


        try {
            // InternalTURN.g:3709:45: (iv_ruleArrow= ruleArrow EOF )
            // InternalTURN.g:3710:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // InternalTURN.g:3716:1: ruleArrow returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '->' ;
    public final AntlrDatatypeRuleToken ruleArrow() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTURN.g:3722:2: (kw= '->' )
            // InternalTURN.g:3723:2: kw= '->'
            {
            kw=(Token)match(input,64,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRulePathBodyNode"
    // InternalTURN.g:3731:1: entryRulePathBodyNode returns [EObject current=null] : iv_rulePathBodyNode= rulePathBodyNode EOF ;
    public final EObject entryRulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNode = null;


        try {
            // InternalTURN.g:3731:53: (iv_rulePathBodyNode= rulePathBodyNode EOF )
            // InternalTURN.g:3732:2: iv_rulePathBodyNode= rulePathBodyNode EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNode=rulePathBodyNode();

            state._fsp--;

             current =iv_rulePathBodyNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNode"


    // $ANTLR start "rulePathBodyNode"
    // InternalTURN.g:3738:1: rulePathBodyNode returns [EObject current=null] : (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) ;
    public final EObject rulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject this_AndJoin_0 = null;

        EObject this_RespRef_1 = null;

        EObject this_OrJoin_2 = null;

        EObject this_WaitingPlace_3 = null;

        EObject this_FailurePoint_4 = null;

        EObject this_Timer_5 = null;

        EObject this_Connect_6 = null;



        	enterRule();

        try {
            // InternalTURN.g:3744:2: ( (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) )
            // InternalTURN.g:3745:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            {
            // InternalTURN.g:3745:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            int alt67=7;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalTURN.g:3746:3: this_AndJoin_0= ruleAndJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getAndJoinParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndJoin_0=ruleAndJoin();

                    state._fsp--;


                    			current = this_AndJoin_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:3755:3: this_RespRef_1= ruleRespRef
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getRespRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RespRef_1=ruleRespRef();

                    state._fsp--;


                    			current = this_RespRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTURN.g:3764:3: this_OrJoin_2= ruleOrJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getOrJoinParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrJoin_2=ruleOrJoin();

                    state._fsp--;


                    			current = this_OrJoin_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTURN.g:3773:3: this_WaitingPlace_3= ruleWaitingPlace
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getWaitingPlaceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_WaitingPlace_3=ruleWaitingPlace();

                    state._fsp--;


                    			current = this_WaitingPlace_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalTURN.g:3782:3: this_FailurePoint_4= ruleFailurePoint
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getFailurePointParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FailurePoint_4=ruleFailurePoint();

                    state._fsp--;


                    			current = this_FailurePoint_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalTURN.g:3791:3: this_Timer_5= ruleTimer
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getTimerParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timer_5=ruleTimer();

                    state._fsp--;


                    			current = this_Timer_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalTURN.g:3800:3: this_Connect_6= ruleConnect
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getConnectParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Connect_6=ruleConnect();

                    state._fsp--;


                    			current = this_Connect_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNode"


    // $ANTLR start "entryRuleRegularEnd"
    // InternalTURN.g:3812:1: entryRuleRegularEnd returns [EObject current=null] : iv_ruleRegularEnd= ruleRegularEnd EOF ;
    public final EObject entryRuleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEnd = null;


        try {
            // InternalTURN.g:3812:51: (iv_ruleRegularEnd= ruleRegularEnd EOF )
            // InternalTURN.g:3813:2: iv_ruleRegularEnd= ruleRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularEnd=ruleRegularEnd();

            state._fsp--;

             current =iv_ruleRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularEnd"


    // $ANTLR start "ruleRegularEnd"
    // InternalTURN.g:3819:1: ruleRegularEnd returns [EObject current=null] : (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) ;
    public final EObject ruleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_EndpointWithConnect_0 = null;

        EObject this_AndFork_1 = null;

        EObject this_OrFork_2 = null;

        EObject this_Stub_3 = null;



        	enterRule();

        try {
            // InternalTURN.g:3825:2: ( (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) )
            // InternalTURN.g:3826:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            {
            // InternalTURN.g:3826:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt68=1;
                }
                break;
            case 79:
                {
                alt68=2;
                }
                break;
            case 77:
                {
                alt68=3;
                }
                break;
            case 81:
            case 120:
            case 121:
                {
                alt68=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalTURN.g:3827:3: this_EndpointWithConnect_0= ruleEndpointWithConnect
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getEndpointWithConnectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EndpointWithConnect_0=ruleEndpointWithConnect();

                    state._fsp--;


                    			current = this_EndpointWithConnect_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:3836:3: this_AndFork_1= ruleAndFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getAndForkParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndFork_1=ruleAndFork();

                    state._fsp--;


                    			current = this_AndFork_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTURN.g:3845:3: this_OrFork_2= ruleOrFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getOrForkParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrFork_2=ruleOrFork();

                    state._fsp--;


                    			current = this_OrFork_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTURN.g:3854:3: this_Stub_3= ruleStub
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getStubParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Stub_3=ruleStub();

                    state._fsp--;


                    			current = this_Stub_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularEnd"


    // $ANTLR start "entryRuleEndpointWithConnect"
    // InternalTURN.g:3866:1: entryRuleEndpointWithConnect returns [EObject current=null] : iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF ;
    public final EObject entryRuleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointWithConnect = null;


        try {
            // InternalTURN.g:3866:60: (iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF )
            // InternalTURN.g:3867:2: iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF
            {
             newCompositeNode(grammarAccess.getEndpointWithConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndpointWithConnect=ruleEndpointWithConnect();

            state._fsp--;

             current =iv_ruleEndpointWithConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndpointWithConnect"


    // $ANTLR start "ruleEndpointWithConnect"
    // InternalTURN.g:3873:1: ruleEndpointWithConnect returns [EObject current=null] : ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) ;
    public final EObject ruleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_regularEnd_0_0 = null;

        EObject lv_connect_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3879:2: ( ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) )
            // InternalTURN.g:3880:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            {
            // InternalTURN.g:3880:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            // InternalTURN.g:3881:3: ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            {
            // InternalTURN.g:3881:3: ( (lv_regularEnd_0_0= ruleEndPoint ) )
            // InternalTURN.g:3882:4: (lv_regularEnd_0_0= ruleEndPoint )
            {
            // InternalTURN.g:3882:4: (lv_regularEnd_0_0= ruleEndPoint )
            // InternalTURN.g:3883:5: lv_regularEnd_0_0= ruleEndPoint
            {

            					newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getRegularEndEndPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_73);
            lv_regularEnd_0_0=ruleEndPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
            					}
            					set(
            						current,
            						"regularEnd",
            						lv_regularEnd_0_0,
            						"org.xtext.example.mydsl.TURN.EndPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:3900:3: (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==64) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalTURN.g:3901:4: otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) )
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_74); 

                    				newLeafNode(otherlv_1, grammarAccess.getEndpointWithConnectAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                    			
                    // InternalTURN.g:3905:4: ( (lv_connect_2_0= ruleConnect ) )
                    // InternalTURN.g:3906:5: (lv_connect_2_0= ruleConnect )
                    {
                    // InternalTURN.g:3906:5: (lv_connect_2_0= ruleConnect )
                    // InternalTURN.g:3907:6: lv_connect_2_0= ruleConnect
                    {

                    						newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getConnectConnectParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connect_2_0=ruleConnect();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
                    						}
                    						set(
                    							current,
                    							"connect",
                    							lv_connect_2_0,
                    							"org.xtext.example.mydsl.TURN.Connect");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndpointWithConnect"


    // $ANTLR start "entryRuleRespRef"
    // InternalTURN.g:3929:1: entryRuleRespRef returns [EObject current=null] : iv_ruleRespRef= ruleRespRef EOF ;
    public final EObject entryRuleRespRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRespRef = null;


        try {
            // InternalTURN.g:3929:48: (iv_ruleRespRef= ruleRespRef EOF )
            // InternalTURN.g:3930:2: iv_ruleRespRef= ruleRespRef EOF
            {
             newCompositeNode(grammarAccess.getRespRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRespRef=ruleRespRef();

            state._fsp--;

             current =iv_ruleRespRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRespRef"


    // $ANTLR start "ruleRespRef"
    // InternalTURN.g:3936:1: ruleRespRef returns [EObject current=null] : (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) ;
    public final EObject ruleRespRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:3942:2: ( (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) )
            // InternalTURN.g:3943:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            {
            // InternalTURN.g:3943:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            // InternalTURN.g:3944:3: otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRespRefAccess().getXKeyword_0());
            		
            // InternalTURN.g:3948:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTURN.g:3949:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTURN.g:3949:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTURN.g:3950:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_75);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:3967:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTURN.g:3968:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTURN.g:3968:4: (lv_longName_2_0= ruleLongName )
            // InternalTURN.g:3969:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRespRef"


    // $ANTLR start "entryRuleOrJoin"
    // InternalTURN.g:3990:1: entryRuleOrJoin returns [EObject current=null] : iv_ruleOrJoin= ruleOrJoin EOF ;
    public final EObject entryRuleOrJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrJoin = null;


        try {
            // InternalTURN.g:3990:47: (iv_ruleOrJoin= ruleOrJoin EOF )
            // InternalTURN.g:3991:2: iv_ruleOrJoin= ruleOrJoin EOF
            {
             newCompositeNode(grammarAccess.getOrJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrJoin=ruleOrJoin();

            state._fsp--;

             current =iv_ruleOrJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrJoin"


    // $ANTLR start "ruleOrJoin"
    // InternalTURN.g:3997:1: ruleOrJoin returns [EObject current=null] : ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) ;
    public final EObject ruleOrJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4003:2: ( ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) )
            // InternalTURN.g:4004:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            {
            // InternalTURN.g:4004:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            // InternalTURN.g:4005:3: () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
            {
            // InternalTURN.g:4005:3: ()
            // InternalTURN.g:4006:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOrJoinAccess().getOrJoinAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOrJoinAccess().getJoinKeyword_1());
            		
            // InternalTURN.g:4016:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTURN.g:4017:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTURN.g:4017:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTURN.g:4018:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_75);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:4035:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTURN.g:4036:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTURN.g:4036:4: (lv_longName_3_0= ruleLongName )
            // InternalTURN.g:4037:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrJoin"


    // $ANTLR start "entryRuleAndJoin"
    // InternalTURN.g:4058:1: entryRuleAndJoin returns [EObject current=null] : iv_ruleAndJoin= ruleAndJoin EOF ;
    public final EObject entryRuleAndJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndJoin = null;


        try {
            // InternalTURN.g:4058:48: (iv_ruleAndJoin= ruleAndJoin EOF )
            // InternalTURN.g:4059:2: iv_ruleAndJoin= ruleAndJoin EOF
            {
             newCompositeNode(grammarAccess.getAndJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndJoin=ruleAndJoin();

            state._fsp--;

             current =iv_ruleAndJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndJoin"


    // $ANTLR start "ruleAndJoin"
    // InternalTURN.g:4065:1: ruleAndJoin returns [EObject current=null] : ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) ;
    public final EObject ruleAndJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4071:2: ( ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) )
            // InternalTURN.g:4072:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            {
            // InternalTURN.g:4072:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            // InternalTURN.g:4073:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
            {
            // InternalTURN.g:4073:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt70=1;
                }
                break;
            case 68:
                {
                alt70=2;
                }
                break;
            case 69:
                {
                alt70=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalTURN.g:4074:4: otherlv_0= 'synch'
                    {
                    otherlv_0=(Token)match(input,67,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getAndJoinAccess().getSynchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTURN.g:4079:4: otherlv_1= 'sync'
                    {
                    otherlv_1=(Token)match(input,68,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getAndJoinAccess().getSyncKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalTURN.g:4084:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,69,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAndJoinAccess().getVerticalLineKeyword_0_2());
                    			

                    }
                    break;

            }

            // InternalTURN.g:4089:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalTURN.g:4090:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalTURN.g:4090:4: (lv_name_3_0= ruleQualifiedName )
            // InternalTURN.g:4091:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_75);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:4108:3: ( (lv_longName_4_0= ruleLongName ) )
            // InternalTURN.g:4109:4: (lv_longName_4_0= ruleLongName )
            {
            // InternalTURN.g:4109:4: (lv_longName_4_0= ruleLongName )
            // InternalTURN.g:4110:5: lv_longName_4_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_4_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_4_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndJoin"


    // $ANTLR start "entryRuleWaitingPlace"
    // InternalTURN.g:4131:1: entryRuleWaitingPlace returns [EObject current=null] : iv_ruleWaitingPlace= ruleWaitingPlace EOF ;
    public final EObject entryRuleWaitingPlace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitingPlace = null;


        try {
            // InternalTURN.g:4131:53: (iv_ruleWaitingPlace= ruleWaitingPlace EOF )
            // InternalTURN.g:4132:2: iv_ruleWaitingPlace= ruleWaitingPlace EOF
            {
             newCompositeNode(grammarAccess.getWaitingPlaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWaitingPlace=ruleWaitingPlace();

            state._fsp--;

             current =iv_ruleWaitingPlace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWaitingPlace"


    // $ANTLR start "ruleWaitingPlace"
    // InternalTURN.g:4138:1: ruleWaitingPlace returns [EObject current=null] : ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) ;
    public final EObject ruleWaitingPlace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_kind_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4144:2: ( ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) )
            // InternalTURN.g:4145:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            {
            // InternalTURN.g:4145:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            // InternalTURN.g:4146:3: ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )?
            {
            // InternalTURN.g:4146:3: ( (lv_kind_0_0= ruleWAITKIND ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=118 && LA71_0<=119)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalTURN.g:4147:4: (lv_kind_0_0= ruleWAITKIND )
                    {
                    // InternalTURN.g:4147:4: (lv_kind_0_0= ruleWAITKIND )
                    // InternalTURN.g:4148:5: lv_kind_0_0= ruleWAITKIND
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getKindWAITKINDEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_76);
                    lv_kind_0_0=ruleWAITKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_0_0,
                    						"org.xtext.example.mydsl.TURN.WAITKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,70,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getWaitingPlaceAccess().getWaitKeyword_1());
            		
            // InternalTURN.g:4169:3: ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalTURN.g:4170:4: ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
                    {
                    // InternalTURN.g:4170:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalTURN.g:4171:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:4171:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalTURN.g:4172:6: lv_name_2_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getNameQualifiedNameParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_64);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:4189:4: ( (lv_longName_3_0= ruleLongName ) )
                    // InternalTURN.g:4190:5: (lv_longName_3_0= ruleLongName )
                    {
                    // InternalTURN.g:4190:5: (lv_longName_3_0= ruleLongName )
                    // InternalTURN.g:4191:6: lv_longName_3_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getLongNameLongNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_65);
                    lv_longName_3_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_3_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:4209:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==26) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalTURN.g:4210:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTURN.g:4210:4: (lv_condition_4_0= ruleCondition )
                    // InternalTURN.g:4211:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getConditionConditionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWaitingPlace"


    // $ANTLR start "entryRuleTimer"
    // InternalTURN.g:4232:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalTURN.g:4232:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalTURN.g:4233:2: iv_ruleTimer= ruleTimer EOF
            {
             newCompositeNode(grammarAccess.getTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimer=ruleTimer();

            state._fsp--;

             current =iv_ruleTimer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimer"


    // $ANTLR start "ruleTimer"
    // InternalTURN.g:4239:1: ruleTimer returns [EObject current=null] : ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'timer' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? otherlv_4= '{' (otherlv_5= 'timeout' )? ( (lv_condition_6_0= ruleCondition ) )? ( (lv_timeoutPath_7_0= rulePathBody ) )? otherlv_8= '}' ) ;
    public final EObject ruleTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Enumerator lv_kind_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_timeoutPath_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4245:2: ( ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'timer' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? otherlv_4= '{' (otherlv_5= 'timeout' )? ( (lv_condition_6_0= ruleCondition ) )? ( (lv_timeoutPath_7_0= rulePathBody ) )? otherlv_8= '}' ) )
            // InternalTURN.g:4246:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'timer' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? otherlv_4= '{' (otherlv_5= 'timeout' )? ( (lv_condition_6_0= ruleCondition ) )? ( (lv_timeoutPath_7_0= rulePathBody ) )? otherlv_8= '}' )
            {
            // InternalTURN.g:4246:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'timer' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? otherlv_4= '{' (otherlv_5= 'timeout' )? ( (lv_condition_6_0= ruleCondition ) )? ( (lv_timeoutPath_7_0= rulePathBody ) )? otherlv_8= '}' )
            // InternalTURN.g:4247:3: ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'timer' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? otherlv_4= '{' (otherlv_5= 'timeout' )? ( (lv_condition_6_0= ruleCondition ) )? ( (lv_timeoutPath_7_0= rulePathBody ) )? otherlv_8= '}'
            {
            // InternalTURN.g:4247:3: ( (lv_kind_0_0= ruleWAITKIND ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=118 && LA74_0<=119)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalTURN.g:4248:4: (lv_kind_0_0= ruleWAITKIND )
                    {
                    // InternalTURN.g:4248:4: (lv_kind_0_0= ruleWAITKIND )
                    // InternalTURN.g:4249:5: lv_kind_0_0= ruleWAITKIND
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getKindWAITKINDEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_78);
                    lv_kind_0_0=ruleWAITKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_0_0,
                    						"org.xtext.example.mydsl.TURN.WAITKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,71,FOLLOW_79); 

            			newLeafNode(otherlv_1, grammarAccess.getTimerAccess().getTimerKeyword_1());
            		
            // InternalTURN.g:4270:3: ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalTURN.g:4271:4: ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
                    {
                    // InternalTURN.g:4271:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalTURN.g:4272:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:4272:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalTURN.g:4273:6: lv_name_2_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getNameQualifiedNameParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:4290:4: ( (lv_longName_3_0= ruleLongName ) )
                    // InternalTURN.g:4291:5: (lv_longName_3_0= ruleLongName )
                    {
                    // InternalTURN.g:4291:5: (lv_longName_3_0= ruleLongName )
                    // InternalTURN.g:4292:6: lv_longName_3_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getLongNameLongNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_longName_3_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_3_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_80); 

            			newLeafNode(otherlv_4, grammarAccess.getTimerAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTURN.g:4314:3: (otherlv_5= 'timeout' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==72) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalTURN.g:4315:4: otherlv_5= 'timeout'
                    {
                    otherlv_5=(Token)match(input,72,FOLLOW_81); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimerAccess().getTimeoutKeyword_4());
                    			

                    }
                    break;

            }

            // InternalTURN.g:4320:3: ( (lv_condition_6_0= ruleCondition ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==26) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalTURN.g:4321:4: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTURN.g:4321:4: (lv_condition_6_0= ruleCondition )
                    // InternalTURN.g:4322:5: lv_condition_6_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getConditionConditionParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_82);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_6_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTURN.g:4339:3: ( (lv_timeoutPath_7_0= rulePathBody ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==64) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalTURN.g:4340:4: (lv_timeoutPath_7_0= rulePathBody )
                    {
                    // InternalTURN.g:4340:4: (lv_timeoutPath_7_0= rulePathBody )
                    // InternalTURN.g:4341:5: lv_timeoutPath_7_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getTimeoutPathPathBodyParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_15);
                    lv_timeoutPath_7_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"timeoutPath",
                    						lv_timeoutPath_7_0,
                    						"org.xtext.example.mydsl.TURN.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTimerAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimer"


    // $ANTLR start "entryRuleConnect"
    // InternalTURN.g:4366:1: entryRuleConnect returns [EObject current=null] : iv_ruleConnect= ruleConnect EOF ;
    public final EObject entryRuleConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnect = null;


        try {
            // InternalTURN.g:4366:48: (iv_ruleConnect= ruleConnect EOF )
            // InternalTURN.g:4367:2: iv_ruleConnect= ruleConnect EOF
            {
             newCompositeNode(grammarAccess.getConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnect=ruleConnect();

            state._fsp--;

             current =iv_ruleConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnect"


    // $ANTLR start "ruleConnect"
    // InternalTURN.g:4373:1: ruleConnect returns [EObject current=null] : (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTURN.g:4379:2: ( (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalTURN.g:4380:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalTURN.g:4380:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalTURN.g:4381:3: otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnectAccess().getTriggerKeyword_0());
            		
            // InternalTURN.g:4385:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:4386:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:4386:4: ( ruleQualifiedName )
            // InternalTURN.g:4387:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConnectAccess().getConnectsToConnectElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_70);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,62,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getConnectAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnect"


    // $ANTLR start "entryRuleFailurePoint"
    // InternalTURN.g:4409:1: entryRuleFailurePoint returns [EObject current=null] : iv_ruleFailurePoint= ruleFailurePoint EOF ;
    public final EObject entryRuleFailurePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailurePoint = null;


        try {
            // InternalTURN.g:4409:53: (iv_ruleFailurePoint= ruleFailurePoint EOF )
            // InternalTURN.g:4410:2: iv_ruleFailurePoint= ruleFailurePoint EOF
            {
             newCompositeNode(grammarAccess.getFailurePointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailurePoint=ruleFailurePoint();

            state._fsp--;

             current =iv_ruleFailurePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailurePoint"


    // $ANTLR start "ruleFailurePoint"
    // InternalTURN.g:4416:1: ruleFailurePoint returns [EObject current=null] : (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) ;
    public final EObject ruleFailurePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;

        EObject lv_failLabel_4_0 = null;

        EObject lv_failLabel_5_0 = null;

        EObject lv_condition_6_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4422:2: ( (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) )
            // InternalTURN.g:4423:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            {
            // InternalTURN.g:4423:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            // InternalTURN.g:4424:3: otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            {
            otherlv_0=(Token)match(input,74,FOLLOW_83); 

            			newLeafNode(otherlv_0, grammarAccess.getFailurePointAccess().getFailKeyword_0());
            		
            // InternalTURN.g:4428:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalTURN.g:4429:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTURN.g:4429:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTURN.g:4430:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:4430:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTURN.g:4431:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_84);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:4448:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTURN.g:4449:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTURN.g:4449:5: (lv_longName_2_0= ruleLongName )
                    // InternalTURN.g:4450:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_85);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:4468:3: ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==26) ) {
                alt80=1;
            }
            else if ( (LA80_0==88) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // InternalTURN.g:4469:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    {
                    // InternalTURN.g:4469:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    // InternalTURN.g:4470:5: ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    {
                    // InternalTURN.g:4470:5: ( (lv_condition_3_0= ruleCondition ) )
                    // InternalTURN.g:4471:6: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTURN.g:4471:6: (lv_condition_3_0= ruleCondition )
                    // InternalTURN.g:4472:7: lv_condition_3_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_0_0_0());
                    						
                    pushFollow(FOLLOW_86);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_3_0,
                    								"org.xtext.example.mydsl.TURN.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:4489:5: ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    // InternalTURN.g:4490:6: (lv_failLabel_4_0= ruleFailureLabel )
                    {
                    // InternalTURN.g:4490:6: (lv_failLabel_4_0= ruleFailureLabel )
                    // InternalTURN.g:4491:7: lv_failLabel_4_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_failLabel_4_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_4_0,
                    								"org.xtext.example.mydsl.TURN.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:4510:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    {
                    // InternalTURN.g:4510:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    // InternalTURN.g:4511:5: ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTURN.g:4511:5: ( (lv_failLabel_5_0= ruleFailureLabel ) )
                    // InternalTURN.g:4512:6: (lv_failLabel_5_0= ruleFailureLabel )
                    {
                    // InternalTURN.g:4512:6: (lv_failLabel_5_0= ruleFailureLabel )
                    // InternalTURN.g:4513:7: lv_failLabel_5_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_87);
                    lv_failLabel_5_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_5_0,
                    								"org.xtext.example.mydsl.TURN.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTURN.g:4530:5: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTURN.g:4531:6: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTURN.g:4531:6: (lv_condition_6_0= ruleCondition )
                    // InternalTURN.g:4532:7: lv_condition_6_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_1_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_6_0,
                    								"org.xtext.example.mydsl.TURN.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailurePoint"


    // $ANTLR start "entryRuleEndPoint"
    // InternalTURN.g:4555:1: entryRuleEndPoint returns [EObject current=null] : iv_ruleEndPoint= ruleEndPoint EOF ;
    public final EObject entryRuleEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndPoint = null;


        try {
            // InternalTURN.g:4555:49: (iv_ruleEndPoint= ruleEndPoint EOF )
            // InternalTURN.g:4556:2: iv_ruleEndPoint= ruleEndPoint EOF
            {
             newCompositeNode(grammarAccess.getEndPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndPoint=ruleEndPoint();

            state._fsp--;

             current =iv_ruleEndPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndPoint"


    // $ANTLR start "ruleEndPoint"
    // InternalTURN.g:4562:1: ruleEndPoint returns [EObject current=null] : (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) ;
    public final EObject ruleEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4568:2: ( (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) )
            // InternalTURN.g:4569:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            {
            // InternalTURN.g:4569:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            // InternalTURN.g:4570:3: otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_88); 

            			newLeafNode(otherlv_0, grammarAccess.getEndPointAccess().getEndKeyword_0());
            		
            // InternalTURN.g:4574:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalTURN.g:4575:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTURN.g:4575:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTURN.g:4576:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:4576:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTURN.g:4577:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_89);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:4594:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTURN.g:4595:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTURN.g:4595:5: (lv_longName_2_0= ruleLongName )
                    // InternalTURN.g:4596:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_90);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:4614:3: ( (lv_condition_3_0= ruleCondition ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==26) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalTURN.g:4615:4: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTURN.g:4615:4: (lv_condition_3_0= ruleCondition )
                    // InternalTURN.g:4616:5: lv_condition_3_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getEndPointAccess().getConditionConditionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_91);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEndPointRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_3_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,76,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEndPointAccess().getFullStopKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndPoint"


    // $ANTLR start "entryRuleOrFork"
    // InternalTURN.g:4641:1: entryRuleOrFork returns [EObject current=null] : iv_ruleOrFork= ruleOrFork EOF ;
    public final EObject entryRuleOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrFork = null;


        try {
            // InternalTURN.g:4641:47: (iv_ruleOrFork= ruleOrFork EOF )
            // InternalTURN.g:4642:2: iv_ruleOrFork= ruleOrFork EOF
            {
             newCompositeNode(grammarAccess.getOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrFork=ruleOrFork();

            state._fsp--;

             current =iv_ruleOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrFork"


    // $ANTLR start "ruleOrFork"
    // InternalTURN.g:4648:1: ruleOrFork returns [EObject current=null] : (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )? ) ;
    public final EObject ruleOrFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_body_4_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_connectingOrBody_8_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4654:2: ( (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )? ) )
            // InternalTURN.g:4655:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )? )
            {
            // InternalTURN.g:4655:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )? )
            // InternalTURN.g:4656:3: otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )?
            {
            otherlv_0=(Token)match(input,77,FOLLOW_92); 

            			newLeafNode(otherlv_0, grammarAccess.getOrForkAccess().getOrKeyword_0());
            		
            // InternalTURN.g:4660:3: ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID||LA84_0==14) ) {
                alt84=1;
            }
            else if ( (LA84_0==26) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalTURN.g:4661:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    {
                    // InternalTURN.g:4661:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    // InternalTURN.g:4662:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}'
                    {
                    // InternalTURN.g:4662:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RULE_ID) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalTURN.g:4663:6: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTURN.g:4663:6: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTURN.g:4664:7: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTURN.g:4664:7: (lv_name_1_0= ruleQualifiedName )
                            // InternalTURN.g:4665:8: lv_name_1_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getNameQualifiedNameParserRuleCall_1_0_0_0_0());
                            							
                            pushFollow(FOLLOW_28);
                            lv_name_1_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_1_0,
                            									"org.xtext.example.mydsl.TURN.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTURN.g:4682:6: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTURN.g:4683:7: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTURN.g:4683:7: (lv_longName_2_0= ruleLongName )
                            // InternalTURN.g:4684:8: lv_longName_2_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getLongNameLongNameParserRuleCall_1_0_0_1_0());
                            							
                            pushFollow(FOLLOW_6);
                            lv_longName_2_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_2_0,
                            									"org.xtext.example.mydsl.TURN.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,14,FOLLOW_87); 

                    					newLeafNode(otherlv_3, grammarAccess.getOrForkAccess().getLeftCurlyBracketKeyword_1_0_1());
                    				
                    // InternalTURN.g:4706:5: ( (lv_body_4_0= ruleOrBody ) )
                    // InternalTURN.g:4707:6: (lv_body_4_0= ruleOrBody )
                    {
                    // InternalTURN.g:4707:6: (lv_body_4_0= ruleOrBody )
                    // InternalTURN.g:4708:7: lv_body_4_0= ruleOrBody
                    {

                    							newCompositeNode(grammarAccess.getOrForkAccess().getBodyOrBodyParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_15);
                    lv_body_4_0=ruleOrBody();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOrForkRule());
                    							}
                    							set(
                    								current,
                    								"body",
                    								lv_body_4_0,
                    								"org.xtext.example.mydsl.TURN.OrBody");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,15,FOLLOW_93); 

                    					newLeafNode(otherlv_5, grammarAccess.getOrForkAccess().getRightCurlyBracketKeyword_1_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:4731:4: ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTURN.g:4731:4: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTURN.g:4732:5: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTURN.g:4732:5: (lv_condition_6_0= ruleCondition )
                    // InternalTURN.g:4733:6: lv_condition_6_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getOrForkAccess().getConditionConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_93);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOrForkRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_6_0,
                    							"org.xtext.example.mydsl.TURN.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:4751:3: (otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==62) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalTURN.g:4752:4: otherlv_7= ';' ( (lv_connectingOrBody_8_0= rulePathBody ) )
                    {
                    otherlv_7=(Token)match(input,62,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getOrForkAccess().getSemicolonKeyword_2_0());
                    			
                    // InternalTURN.g:4756:4: ( (lv_connectingOrBody_8_0= rulePathBody ) )
                    // InternalTURN.g:4757:5: (lv_connectingOrBody_8_0= rulePathBody )
                    {
                    // InternalTURN.g:4757:5: (lv_connectingOrBody_8_0= rulePathBody )
                    // InternalTURN.g:4758:6: lv_connectingOrBody_8_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getOrForkAccess().getConnectingOrBodyPathBodyParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connectingOrBody_8_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOrForkRule());
                    						}
                    						set(
                    							current,
                    							"connectingOrBody",
                    							lv_connectingOrBody_8_0,
                    							"org.xtext.example.mydsl.TURN.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrFork"


    // $ANTLR start "entryRuleOrBody"
    // InternalTURN.g:4780:1: entryRuleOrBody returns [EObject current=null] : iv_ruleOrBody= ruleOrBody EOF ;
    public final EObject entryRuleOrBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBody = null;


        try {
            // InternalTURN.g:4780:47: (iv_ruleOrBody= ruleOrBody EOF )
            // InternalTURN.g:4781:2: iv_ruleOrBody= ruleOrBody EOF
            {
             newCompositeNode(grammarAccess.getOrBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBody=ruleOrBody();

            state._fsp--;

             current =iv_ruleOrBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrBody"


    // $ANTLR start "ruleOrBody"
    // InternalTURN.g:4787:1: ruleOrBody returns [EObject current=null] : this_ElseOrForkBody_0= ruleElseOrForkBody ;
    public final EObject ruleOrBody() throws RecognitionException {
        EObject current = null;

        EObject this_ElseOrForkBody_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4793:2: (this_ElseOrForkBody_0= ruleElseOrForkBody )
            // InternalTURN.g:4794:2: this_ElseOrForkBody_0= ruleElseOrForkBody
            {

            		newCompositeNode(grammarAccess.getOrBodyAccess().getElseOrForkBodyParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ElseOrForkBody_0=ruleElseOrForkBody();

            state._fsp--;


            		current = this_ElseOrForkBody_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrBody"


    // $ANTLR start "entryRuleElseOrForkBody"
    // InternalTURN.g:4805:1: entryRuleElseOrForkBody returns [EObject current=null] : iv_ruleElseOrForkBody= ruleElseOrForkBody EOF ;
    public final EObject entryRuleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseOrForkBody = null;


        try {
            // InternalTURN.g:4805:55: (iv_ruleElseOrForkBody= ruleElseOrForkBody EOF )
            // InternalTURN.g:4806:2: iv_ruleElseOrForkBody= ruleElseOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getElseOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseOrForkBody=ruleElseOrForkBody();

            state._fsp--;

             current =iv_ruleElseOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseOrForkBody"


    // $ANTLR start "ruleElseOrForkBody"
    // InternalTURN.g:4812:1: ruleElseOrForkBody returns [EObject current=null] : (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) ;
    public final EObject ruleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_OrForkBody_0 = null;

        EObject lv_elseBody_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4818:2: ( (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) )
            // InternalTURN.g:4819:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            {
            // InternalTURN.g:4819:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            // InternalTURN.g:4820:3: this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            {

            			newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getOrForkBodyParserRuleCall_0());
            		
            pushFollow(FOLLOW_94);
            this_OrForkBody_0=ruleOrForkBody();

            state._fsp--;


            			current = this_OrForkBody_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTURN.g:4828:3: (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==78) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalTURN.g:4829:4: otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) )
                    {
                    otherlv_1=(Token)match(input,78,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getElseOrForkBodyAccess().getElseKeyword_1_0());
                    			
                    // InternalTURN.g:4833:4: ( (lv_elseBody_2_0= rulePathBody ) )
                    // InternalTURN.g:4834:5: (lv_elseBody_2_0= rulePathBody )
                    {
                    // InternalTURN.g:4834:5: (lv_elseBody_2_0= rulePathBody )
                    // InternalTURN.g:4835:6: lv_elseBody_2_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getElseBodyPathBodyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_elseBody_2_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElseOrForkBodyRule());
                    						}
                    						set(
                    							current,
                    							"elseBody",
                    							lv_elseBody_2_0,
                    							"org.xtext.example.mydsl.TURN.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseOrForkBody"


    // $ANTLR start "entryRuleOrForkBody"
    // InternalTURN.g:4857:1: entryRuleOrForkBody returns [EObject current=null] : iv_ruleOrForkBody= ruleOrForkBody EOF ;
    public final EObject entryRuleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrForkBody = null;


        try {
            // InternalTURN.g:4857:51: (iv_ruleOrForkBody= ruleOrForkBody EOF )
            // InternalTURN.g:4858:2: iv_ruleOrForkBody= ruleOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrForkBody=ruleOrForkBody();

            state._fsp--;

             current =iv_ruleOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrForkBody"


    // $ANTLR start "ruleOrForkBody"
    // InternalTURN.g:4864:1: ruleOrForkBody returns [EObject current=null] : ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ ;
    public final EObject ruleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject lv_regularBody_0_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4870:2: ( ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ )
            // InternalTURN.g:4871:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            {
            // InternalTURN.g:4871:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==26) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalTURN.g:4872:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    {
            	    // InternalTURN.g:4872:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    // InternalTURN.g:4873:4: lv_regularBody_0_0= ruleRegularOrFork
            	    {

            	    				newCompositeNode(grammarAccess.getOrForkBodyAccess().getRegularBodyRegularOrForkParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_65);
            	    lv_regularBody_0_0=ruleRegularOrFork();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getOrForkBodyRule());
            	    				}
            	    				add(
            	    					current,
            	    					"regularBody",
            	    					lv_regularBody_0_0,
            	    					"org.xtext.example.mydsl.TURN.RegularOrFork");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt87 >= 1 ) break loop87;
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrForkBody"


    // $ANTLR start "entryRuleRegularOrFork"
    // InternalTURN.g:4893:1: entryRuleRegularOrFork returns [EObject current=null] : iv_ruleRegularOrFork= ruleRegularOrFork EOF ;
    public final EObject entryRuleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularOrFork = null;


        try {
            // InternalTURN.g:4893:54: (iv_ruleRegularOrFork= ruleRegularOrFork EOF )
            // InternalTURN.g:4894:2: iv_ruleRegularOrFork= ruleRegularOrFork EOF
            {
             newCompositeNode(grammarAccess.getRegularOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularOrFork=ruleRegularOrFork();

            state._fsp--;

             current =iv_ruleRegularOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularOrFork"


    // $ANTLR start "ruleRegularOrFork"
    // InternalTURN.g:4900:1: ruleRegularOrFork returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject ruleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4906:2: ( ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTURN.g:4907:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTURN.g:4907:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTURN.g:4908:3: ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTURN.g:4908:3: ( (lv_condition_0_0= ruleCondition ) )
            // InternalTURN.g:4909:4: (lv_condition_0_0= ruleCondition )
            {
            // InternalTURN.g:4909:4: (lv_condition_0_0= ruleCondition )
            // InternalTURN.g:4910:5: lv_condition_0_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getConditionConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
            lv_condition_0_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_0_0,
            						"org.xtext.example.mydsl.TURN.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:4927:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTURN.g:4928:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTURN.g:4928:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTURN.g:4929:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.xtext.example.mydsl.TURN.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularOrFork"


    // $ANTLR start "entryRuleAndFork"
    // InternalTURN.g:4950:1: entryRuleAndFork returns [EObject current=null] : iv_ruleAndFork= ruleAndFork EOF ;
    public final EObject entryRuleAndFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndFork = null;


        try {
            // InternalTURN.g:4950:48: (iv_ruleAndFork= ruleAndFork EOF )
            // InternalTURN.g:4951:2: iv_ruleAndFork= ruleAndFork EOF
            {
             newCompositeNode(grammarAccess.getAndForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndFork=ruleAndFork();

            state._fsp--;

             current =iv_ruleAndFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndFork"


    // $ANTLR start "ruleAndFork"
    // InternalTURN.g:4957:1: ruleAndFork returns [EObject current=null] : (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )? ) ;
    public final EObject ruleAndFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_pathbody_5_0 = null;

        EObject lv_connectingAndBody_8_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:4963:2: ( (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )? ) )
            // InternalTURN.g:4964:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )? )
            {
            // InternalTURN.g:4964:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )? )
            // InternalTURN.g:4965:3: otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )?
            {
            otherlv_0=(Token)match(input,79,FOLLOW_79); 

            			newLeafNode(otherlv_0, grammarAccess.getAndForkAccess().getAndKeyword_0());
            		
            // InternalTURN.g:4969:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalTURN.g:4970:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTURN.g:4970:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTURN.g:4971:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTURN.g:4971:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTURN.g:4972:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.example.mydsl.TURN.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:4989:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTURN.g:4990:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTURN.g:4990:5: (lv_longName_2_0= ruleLongName )
                    // InternalTURN.g:4991:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.example.mydsl.TURN.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,14,FOLLOW_95); 

            			newLeafNode(otherlv_3, grammarAccess.getAndForkAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTURN.g:5013:3: (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==80) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalTURN.g:5014:4: otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) )
            	    {
            	    otherlv_4=(Token)match(input,80,FOLLOW_63); 

            	    				newLeafNode(otherlv_4, grammarAccess.getAndForkAccess().getAsteriskKeyword_3_0());
            	    			
            	    // InternalTURN.g:5018:4: ( (lv_pathbody_5_0= rulePathBody ) )
            	    // InternalTURN.g:5019:5: (lv_pathbody_5_0= rulePathBody )
            	    {
            	    // InternalTURN.g:5019:5: (lv_pathbody_5_0= rulePathBody )
            	    // InternalTURN.g:5020:6: lv_pathbody_5_0= rulePathBody
            	    {

            	    						newCompositeNode(grammarAccess.getAndForkAccess().getPathbodyPathBodyParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_95);
            	    lv_pathbody_5_0=rulePathBody();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndForkRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathbody",
            	    							lv_pathbody_5_0,
            	    							"org.xtext.example.mydsl.TURN.PathBody");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_93); 

            			newLeafNode(otherlv_6, grammarAccess.getAndForkAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalTURN.g:5042:3: (otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==62) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalTURN.g:5043:4: otherlv_7= ';' ( (lv_connectingAndBody_8_0= rulePathBody ) )
                    {
                    otherlv_7=(Token)match(input,62,FOLLOW_63); 

                    				newLeafNode(otherlv_7, grammarAccess.getAndForkAccess().getSemicolonKeyword_5_0());
                    			
                    // InternalTURN.g:5047:4: ( (lv_connectingAndBody_8_0= rulePathBody ) )
                    // InternalTURN.g:5048:5: (lv_connectingAndBody_8_0= rulePathBody )
                    {
                    // InternalTURN.g:5048:5: (lv_connectingAndBody_8_0= rulePathBody )
                    // InternalTURN.g:5049:6: lv_connectingAndBody_8_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getConnectingAndBodyPathBodyParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connectingAndBody_8_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"connectingAndBody",
                    							lv_connectingAndBody_8_0,
                    							"org.xtext.example.mydsl.TURN.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndFork"


    // $ANTLR start "entryRuleStub"
    // InternalTURN.g:5071:1: entryRuleStub returns [EObject current=null] : iv_ruleStub= ruleStub EOF ;
    public final EObject entryRuleStub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStub = null;


        try {
            // InternalTURN.g:5071:45: (iv_ruleStub= ruleStub EOF )
            // InternalTURN.g:5072:2: iv_ruleStub= ruleStub EOF
            {
             newCompositeNode(grammarAccess.getStubRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStub=ruleStub();

            state._fsp--;

             current =iv_ruleStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStub"


    // $ANTLR start "ruleStub"
    // InternalTURN.g:5078:1: ruleStub returns [EObject current=null] : ( ( (lv_stubType_0_0= ruleSTUBTYPE ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )? ) ;
    public final EObject ruleStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_stubType_0_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_longName_5_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_outPaths_9_0 = null;

        EObject lv_connectingStubBody_12_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5084:2: ( ( ( (lv_stubType_0_0= ruleSTUBTYPE ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )? ) )
            // InternalTURN.g:5085:2: ( ( (lv_stubType_0_0= ruleSTUBTYPE ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )? )
            {
            // InternalTURN.g:5085:2: ( ( (lv_stubType_0_0= ruleSTUBTYPE ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )? )
            // InternalTURN.g:5086:3: ( (lv_stubType_0_0= ruleSTUBTYPE ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )?
            {
            // InternalTURN.g:5086:3: ( (lv_stubType_0_0= ruleSTUBTYPE ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=120 && LA91_0<=121)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalTURN.g:5087:4: (lv_stubType_0_0= ruleSTUBTYPE )
                    {
                    // InternalTURN.g:5087:4: (lv_stubType_0_0= ruleSTUBTYPE )
                    // InternalTURN.g:5088:5: lv_stubType_0_0= ruleSTUBTYPE
                    {

                    					newCompositeNode(grammarAccess.getStubAccess().getStubTypeSTUBTYPEEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_96);
                    lv_stubType_0_0=ruleSTUBTYPE();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStubRule());
                    					}
                    					set(
                    						current,
                    						"stubType",
                    						lv_stubType_0_0,
                    						"org.xtext.example.mydsl.TURN.STUBTYPE");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,81,FOLLOW_97); 

            			newLeafNode(otherlv_1, grammarAccess.getStubAccess().getStubKeyword_1());
            		
            // InternalTURN.g:5109:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==63) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalTURN.g:5110:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubAccess().getInKeyword_2_0());
                    			
                    // InternalTURN.g:5114:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTURN.g:5115:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTURN.g:5115:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTURN.g:5116:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_98);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.xtext.example.mydsl.TURN.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:5134:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )
            int alt94=2;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // InternalTURN.g:5135:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    {
                    // InternalTURN.g:5135:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    // InternalTURN.g:5136:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) )
                    {
                    // InternalTURN.g:5136:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==RULE_ID) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // InternalTURN.g:5137:6: ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) )
                            {
                            // InternalTURN.g:5137:6: ( (lv_name_4_0= ruleQualifiedName ) )
                            // InternalTURN.g:5138:7: (lv_name_4_0= ruleQualifiedName )
                            {
                            // InternalTURN.g:5138:7: (lv_name_4_0= ruleQualifiedName )
                            // InternalTURN.g:5139:8: lv_name_4_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getNameQualifiedNameParserRuleCall_3_0_0_0_0());
                            							
                            pushFollow(FOLLOW_99);
                            lv_name_4_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_4_0,
                            									"org.xtext.example.mydsl.TURN.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTURN.g:5156:6: ( (lv_longName_5_0= ruleLongName ) )
                            // InternalTURN.g:5157:7: (lv_longName_5_0= ruleLongName )
                            {
                            // InternalTURN.g:5157:7: (lv_longName_5_0= ruleLongName )
                            // InternalTURN.g:5158:8: lv_longName_5_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getLongNameLongNameParserRuleCall_3_0_0_1_0());
                            							
                            pushFollow(FOLLOW_98);
                            lv_longName_5_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_5_0,
                            									"org.xtext.example.mydsl.TURN.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalTURN.g:5176:5: ( (lv_params_6_0= ruleStubParameters ) )
                    // InternalTURN.g:5177:6: (lv_params_6_0= ruleStubParameters )
                    {
                    // InternalTURN.g:5177:6: (lv_params_6_0= ruleStubParameters )
                    // InternalTURN.g:5178:7: lv_params_6_0= ruleStubParameters
                    {

                    							newCompositeNode(grammarAccess.getStubAccess().getParamsStubParametersParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_100);
                    lv_params_6_0=ruleStubParameters();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStubRule());
                    							}
                    							set(
                    								current,
                    								"params",
                    								lv_params_6_0,
                    								"org.xtext.example.mydsl.TURN.StubParameters");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:5197:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTURN.g:5197:4: ( ( ruleQualifiedName ) )
                    // InternalTURN.g:5198:5: ( ruleQualifiedName )
                    {
                    // InternalTURN.g:5198:5: ( ruleQualifiedName )
                    // InternalTURN.g:5199:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStubAccess().getStubRefStubDeclarationCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_100);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:5214:3: (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==14) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalTURN.g:5215:4: otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_101); 

                    				newLeafNode(otherlv_8, grammarAccess.getStubAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTURN.g:5219:4: ( (lv_outPaths_9_0= ruleStubOutPath ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==84) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalTURN.g:5220:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    {
                    	    // InternalTURN.g:5220:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    // InternalTURN.g:5221:6: lv_outPaths_9_0= ruleStubOutPath
                    	    {

                    	    						newCompositeNode(grammarAccess.getStubAccess().getOutPathsStubOutPathParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_101);
                    	    lv_outPaths_9_0=ruleStubOutPath();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStubRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"outPaths",
                    	    							lv_outPaths_9_0,
                    	    							"org.xtext.example.mydsl.TURN.StubOutPath");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,15,FOLLOW_93); 

                    				newLeafNode(otherlv_10, grammarAccess.getStubAccess().getRightCurlyBracketKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalTURN.g:5243:3: (otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==62) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalTURN.g:5244:4: otherlv_11= ';' ( (lv_connectingStubBody_12_0= rulePathBody ) )
                    {
                    otherlv_11=(Token)match(input,62,FOLLOW_63); 

                    				newLeafNode(otherlv_11, grammarAccess.getStubAccess().getSemicolonKeyword_5_0());
                    			
                    // InternalTURN.g:5248:4: ( (lv_connectingStubBody_12_0= rulePathBody ) )
                    // InternalTURN.g:5249:5: (lv_connectingStubBody_12_0= rulePathBody )
                    {
                    // InternalTURN.g:5249:5: (lv_connectingStubBody_12_0= rulePathBody )
                    // InternalTURN.g:5250:6: lv_connectingStubBody_12_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getStubAccess().getConnectingStubBodyPathBodyParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connectingStubBody_12_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubRule());
                    						}
                    						set(
                    							current,
                    							"connectingStubBody",
                    							lv_connectingStubBody_12_0,
                    							"org.xtext.example.mydsl.TURN.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStub"


    // $ANTLR start "entryRuleStubParameters"
    // InternalTURN.g:5272:1: entryRuleStubParameters returns [EObject current=null] : iv_ruleStubParameters= ruleStubParameters EOF ;
    public final EObject entryRuleStubParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubParameters = null;


        try {
            // InternalTURN.g:5272:55: (iv_ruleStubParameters= ruleStubParameters EOF )
            // InternalTURN.g:5273:2: iv_ruleStubParameters= ruleStubParameters EOF
            {
             newCompositeNode(grammarAccess.getStubParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubParameters=ruleStubParameters();

            state._fsp--;

             current =iv_ruleStubParameters; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubParameters"


    // $ANTLR start "ruleStubParameters"
    // InternalTURN.g:5279:1: ruleStubParameters returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) ;
    public final EObject ruleStubParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_plugin_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5285:2: ( ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) )
            // InternalTURN.g:5286:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            {
            // InternalTURN.g:5286:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            // InternalTURN.g:5287:3: () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')'
            {
            // InternalTURN.g:5287:3: ()
            // InternalTURN.g:5288:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStubParametersAccess().getStubParametersAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,82,FOLLOW_102); 

            			newLeafNode(otherlv_1, grammarAccess.getStubParametersAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTURN.g:5298:3: ( (lv_plugin_2_0= rulePluginBinding ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==RULE_ID||LA98_0==26||LA98_0==85) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalTURN.g:5299:4: (lv_plugin_2_0= rulePluginBinding )
            	    {
            	    // InternalTURN.g:5299:4: (lv_plugin_2_0= rulePluginBinding )
            	    // InternalTURN.g:5300:5: lv_plugin_2_0= rulePluginBinding
            	    {

            	    					newCompositeNode(grammarAccess.getStubParametersAccess().getPluginPluginBindingParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_102);
            	    lv_plugin_2_0=rulePluginBinding();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStubParametersRule());
            	    					}
            	    					add(
            	    						current,
            	    						"plugin",
            	    						lv_plugin_2_0,
            	    						"org.xtext.example.mydsl.TURN.PluginBinding");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);

            otherlv_3=(Token)match(input,83,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getStubParametersAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubParameters"


    // $ANTLR start "entryRuleStubDeclaration"
    // InternalTURN.g:5325:1: entryRuleStubDeclaration returns [EObject current=null] : iv_ruleStubDeclaration= ruleStubDeclaration EOF ;
    public final EObject entryRuleStubDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubDeclaration = null;


        try {
            // InternalTURN.g:5325:56: (iv_ruleStubDeclaration= ruleStubDeclaration EOF )
            // InternalTURN.g:5326:2: iv_ruleStubDeclaration= ruleStubDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStubDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubDeclaration=ruleStubDeclaration();

            state._fsp--;

             current =iv_ruleStubDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubDeclaration"


    // $ANTLR start "ruleStubDeclaration"
    // InternalTURN.g:5332:1: ruleStubDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) ;
    public final EObject ruleStubDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5338:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) )
            // InternalTURN.g:5339:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            {
            // InternalTURN.g:5339:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            // InternalTURN.g:5340:3: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) )
            {
            // InternalTURN.g:5340:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalTURN.g:5341:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalTURN.g:5341:4: (lv_name_0_0= ruleQualifiedName )
            // InternalTURN.g:5342:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_103);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:5359:3: ( (lv_longName_1_0= ruleLongName ) )
            // InternalTURN.g:5360:4: (lv_longName_1_0= ruleLongName )
            {
            // InternalTURN.g:5360:4: (lv_longName_1_0= ruleLongName )
            // InternalTURN.g:5361:5: lv_longName_1_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getLongNameLongNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
            lv_longName_1_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_1_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_98); 

            			newLeafNode(otherlv_2, grammarAccess.getStubDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalTURN.g:5382:3: ( (lv_params_3_0= ruleStubParameters ) )
            // InternalTURN.g:5383:4: (lv_params_3_0= ruleStubParameters )
            {
            // InternalTURN.g:5383:4: (lv_params_3_0= ruleStubParameters )
            // InternalTURN.g:5384:5: lv_params_3_0= ruleStubParameters
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getParamsStubParametersParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_params_3_0=ruleStubParameters();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"params",
            						lv_params_3_0,
            						"org.xtext.example.mydsl.TURN.StubParameters");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubDeclaration"


    // $ANTLR start "entryRuleStubOutPath"
    // InternalTURN.g:5405:1: entryRuleStubOutPath returns [EObject current=null] : iv_ruleStubOutPath= ruleStubOutPath EOF ;
    public final EObject entryRuleStubOutPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubOutPath = null;


        try {
            // InternalTURN.g:5405:52: (iv_ruleStubOutPath= ruleStubOutPath EOF )
            // InternalTURN.g:5406:2: iv_ruleStubOutPath= ruleStubOutPath EOF
            {
             newCompositeNode(grammarAccess.getStubOutPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubOutPath=ruleStubOutPath();

            state._fsp--;

             current =iv_ruleStubOutPath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubOutPath"


    // $ANTLR start "ruleStubOutPath"
    // InternalTURN.g:5412:1: ruleStubOutPath returns [EObject current=null] : ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) ;
    public final EObject ruleStubOutPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_index_1_0 = null;

        AntlrDatatypeRuleToken lv_threshold_4_0 = null;

        EObject lv_path_6_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5418:2: ( ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) )
            // InternalTURN.g:5419:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            {
            // InternalTURN.g:5419:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            // InternalTURN.g:5420:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) )
            {
            // InternalTURN.g:5420:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) )
            // InternalTURN.g:5421:4: otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) )
            {
            otherlv_0=(Token)match(input,84,FOLLOW_54); 

            				newLeafNode(otherlv_0, grammarAccess.getStubOutPathAccess().getOutKeyword_0_0());
            			
            // InternalTURN.g:5425:4: ( (lv_index_1_0= rulePositiveInteger ) )
            // InternalTURN.g:5426:5: (lv_index_1_0= rulePositiveInteger )
            {
            // InternalTURN.g:5426:5: (lv_index_1_0= rulePositiveInteger )
            // InternalTURN.g:5427:6: lv_index_1_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getStubOutPathAccess().getIndexPositiveIntegerParserRuleCall_0_1_0());
            					
            pushFollow(FOLLOW_104);
            lv_index_1_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_1_0,
            							"org.xtext.example.mydsl.TURN.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalTURN.g:5445:3: (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==49) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalTURN.g:5446:4: otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']'
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_87); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubOutPathAccess().getThresholdKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,26,FOLLOW_54); 

                    				newLeafNode(otherlv_3, grammarAccess.getStubOutPathAccess().getLeftSquareBracketKeyword_1_1());
                    			
                    // InternalTURN.g:5454:4: ( (lv_threshold_4_0= rulePositiveInteger ) )
                    // InternalTURN.g:5455:5: (lv_threshold_4_0= rulePositiveInteger )
                    {
                    // InternalTURN.g:5455:5: (lv_threshold_4_0= rulePositiveInteger )
                    // InternalTURN.g:5456:6: lv_threshold_4_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubOutPathAccess().getThresholdPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_threshold_4_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
                    						}
                    						set(
                    							current,
                    							"threshold",
                    							lv_threshold_4_0,
                    							"org.xtext.example.mydsl.TURN.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getStubOutPathAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalTURN.g:5478:3: ( (lv_path_6_0= rulePathBody ) )
            // InternalTURN.g:5479:4: (lv_path_6_0= rulePathBody )
            {
            // InternalTURN.g:5479:4: (lv_path_6_0= rulePathBody )
            // InternalTURN.g:5480:5: lv_path_6_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getStubOutPathAccess().getPathPathBodyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_6_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_6_0,
            						"org.xtext.example.mydsl.TURN.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubOutPath"


    // $ANTLR start "entryRulePluginBinding"
    // InternalTURN.g:5501:1: entryRulePluginBinding returns [EObject current=null] : iv_rulePluginBinding= rulePluginBinding EOF ;
    public final EObject entryRulePluginBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginBinding = null;


        try {
            // InternalTURN.g:5501:54: (iv_rulePluginBinding= rulePluginBinding EOF )
            // InternalTURN.g:5502:2: iv_rulePluginBinding= rulePluginBinding EOF
            {
             newCompositeNode(grammarAccess.getPluginBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePluginBinding=rulePluginBinding();

            state._fsp--;

             current =iv_rulePluginBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePluginBinding"


    // $ANTLR start "rulePluginBinding"
    // InternalTURN.g:5508:1: rulePluginBinding returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) ;
    public final EObject rulePluginBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_0_0 = null;

        AntlrDatatypeRuleToken lv_replication_2_0 = null;

        EObject lv_binding_5_0 = null;

        EObject lv_bindings_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5514:2: ( ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) )
            // InternalTURN.g:5515:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            {
            // InternalTURN.g:5515:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            // InternalTURN.g:5516:3: ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            {
            // InternalTURN.g:5516:3: ( (lv_condition_0_0= ruleCondition ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==26) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalTURN.g:5517:4: (lv_condition_0_0= ruleCondition )
                    {
                    // InternalTURN.g:5517:4: (lv_condition_0_0= ruleCondition )
                    // InternalTURN.g:5518:5: lv_condition_0_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getPluginBindingAccess().getConditionConditionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_105);
                    lv_condition_0_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_0_0,
                    						"org.xtext.example.mydsl.TURN.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTURN.g:5535:3: (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==85) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalTURN.g:5536:4: otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) )
                    {
                    otherlv_1=(Token)match(input,85,FOLLOW_54); 

                    				newLeafNode(otherlv_1, grammarAccess.getPluginBindingAccess().getReplicationKeyword_1_0());
                    			
                    // InternalTURN.g:5540:4: ( (lv_replication_2_0= rulePositiveInteger ) )
                    // InternalTURN.g:5541:5: (lv_replication_2_0= rulePositiveInteger )
                    {
                    // InternalTURN.g:5541:5: (lv_replication_2_0= rulePositiveInteger )
                    // InternalTURN.g:5542:6: lv_replication_2_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getReplicationPositiveIntegerParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_replication_2_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"replication",
                    							lv_replication_2_0,
                    							"org.xtext.example.mydsl.TURN.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTURN.g:5560:3: ( (otherlv_3= RULE_ID ) )
            // InternalTURN.g:5561:4: (otherlv_3= RULE_ID )
            {
            // InternalTURN.g:5561:4: (otherlv_3= RULE_ID )
            // InternalTURN.g:5562:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginBindingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_106); 

            					newLeafNode(otherlv_3, grammarAccess.getPluginBindingAccess().getMapUCMmapCrossReference_2_0());
            				

            }


            }

            // InternalTURN.g:5573:3: (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==23) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalTURN.g:5574:4: otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPluginBindingAccess().getColonKeyword_3_0());
                    			
                    // InternalTURN.g:5578:4: ( (lv_binding_5_0= ruleBinding ) )
                    // InternalTURN.g:5579:5: (lv_binding_5_0= ruleBinding )
                    {
                    // InternalTURN.g:5579:5: (lv_binding_5_0= ruleBinding )
                    // InternalTURN.g:5580:6: lv_binding_5_0= ruleBinding
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingBindingParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_binding_5_0=ruleBinding();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"binding",
                    							lv_binding_5_0,
                    							"org.xtext.example.mydsl.TURN.Binding");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:5597:4: (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==24) ) {
                            alt102=1;
                        }


                        switch (alt102) {
                    	case 1 :
                    	    // InternalTURN.g:5598:5: otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPluginBindingAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTURN.g:5602:5: ( (lv_bindings_7_0= ruleBinding ) )
                    	    // InternalTURN.g:5603:6: (lv_bindings_7_0= ruleBinding )
                    	    {
                    	    // InternalTURN.g:5603:6: (lv_bindings_7_0= ruleBinding )
                    	    // InternalTURN.g:5604:7: lv_bindings_7_0= ruleBinding
                    	    {

                    	    							newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingsBindingParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_bindings_7_0=ruleBinding();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"bindings",
                    	    								lv_bindings_7_0,
                    	    								"org.xtext.example.mydsl.TURN.Binding");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop102;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluginBinding"


    // $ANTLR start "entryRuleComponentRef"
    // InternalTURN.g:5627:1: entryRuleComponentRef returns [EObject current=null] : iv_ruleComponentRef= ruleComponentRef EOF ;
    public final EObject entryRuleComponentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentRef = null;


        try {
            // InternalTURN.g:5627:53: (iv_ruleComponentRef= ruleComponentRef EOF )
            // InternalTURN.g:5628:2: iv_ruleComponentRef= ruleComponentRef EOF
            {
             newCompositeNode(grammarAccess.getComponentRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentRef=ruleComponentRef();

            state._fsp--;

             current =iv_ruleComponentRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentRef"


    // $ANTLR start "ruleComponentRef"
    // InternalTURN.g:5634:1: ruleComponentRef returns [EObject current=null] : ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) ;
    public final EObject ruleComponentRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_kind_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_element_5_0 = null;

        EObject lv_elements_7_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5640:2: ( ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) )
            // InternalTURN.g:5641:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            {
            // InternalTURN.g:5641:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            // InternalTURN.g:5642:3: (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            {
            // InternalTURN.g:5642:3: (otherlv_0= 'protected' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==86) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalTURN.g:5643:4: otherlv_0= 'protected'
                    {
                    otherlv_0=(Token)match(input,86,FOLLOW_107); 

                    				newLeafNode(otherlv_0, grammarAccess.getComponentRefAccess().getProtectedKeyword_0());
                    			

                    }
                    break;

            }

            // InternalTURN.g:5648:3: ( (lv_kind_1_0= ruleCOMPONENTKIND ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==32||(LA105_0>=122 && LA105_0<=126)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalTURN.g:5649:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    {
                    // InternalTURN.g:5649:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    // InternalTURN.g:5650:5: lv_kind_1_0= ruleCOMPONENTKIND
                    {

                    					newCompositeNode(grammarAccess.getComponentRefAccess().getKindCOMPONENTKINDEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_kind_1_0=ruleCOMPONENTKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_1_0,
                    						"org.xtext.example.mydsl.TURN.COMPONENTKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTURN.g:5667:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTURN.g:5668:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTURN.g:5668:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTURN.g:5669:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:5686:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTURN.g:5687:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTURN.g:5687:4: (lv_longName_3_0= ruleLongName )
            // InternalTURN.g:5688:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_106);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.example.mydsl.TURN.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTURN.g:5705:3: (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==23) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalTURN.g:5706:4: otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getComponentRefAccess().getColonKeyword_4_0());
                    			
                    // InternalTURN.g:5710:4: ( (lv_element_5_0= ruleBoundOption ) )
                    // InternalTURN.g:5711:5: (lv_element_5_0= ruleBoundOption )
                    {
                    // InternalTURN.g:5711:5: (lv_element_5_0= ruleBoundOption )
                    // InternalTURN.g:5712:6: lv_element_5_0= ruleBoundOption
                    {

                    						newCompositeNode(grammarAccess.getComponentRefAccess().getElementBoundOptionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_element_5_0=ruleBoundOption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    						}
                    						set(
                    							current,
                    							"element",
                    							lv_element_5_0,
                    							"org.xtext.example.mydsl.TURN.BoundOption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTURN.g:5729:4: (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==24) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalTURN.g:5730:5: otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getComponentRefAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalTURN.g:5734:5: ( (lv_elements_7_0= ruleBoundOption ) )
                    	    // InternalTURN.g:5735:6: (lv_elements_7_0= ruleBoundOption )
                    	    {
                    	    // InternalTURN.g:5735:6: (lv_elements_7_0= ruleBoundOption )
                    	    // InternalTURN.g:5736:7: lv_elements_7_0= ruleBoundOption
                    	    {

                    	    							newCompositeNode(grammarAccess.getComponentRefAccess().getElementsBoundOptionParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_elements_7_0=ruleBoundOption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_7_0,
                    	    								"org.xtext.example.mydsl.TURN.BoundOption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop106;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentRef"


    // $ANTLR start "entryRuleBoundOption"
    // InternalTURN.g:5759:1: entryRuleBoundOption returns [EObject current=null] : iv_ruleBoundOption= ruleBoundOption EOF ;
    public final EObject entryRuleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundOption = null;


        try {
            // InternalTURN.g:5759:52: (iv_ruleBoundOption= ruleBoundOption EOF )
            // InternalTURN.g:5760:2: iv_ruleBoundOption= ruleBoundOption EOF
            {
             newCompositeNode(grammarAccess.getBoundOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundOption=ruleBoundOption();

            state._fsp--;

             current =iv_ruleBoundOption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundOption"


    // $ANTLR start "ruleBoundOption"
    // InternalTURN.g:5766:1: ruleBoundOption returns [EObject current=null] : (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) ;
    public final EObject ruleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject this_BoundElement_0 = null;

        EObject this_LongBoundElement_1 = null;



        	enterRule();

        try {
            // InternalTURN.g:5772:2: ( (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) )
            // InternalTURN.g:5773:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            {
            // InternalTURN.g:5773:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            int alt108=2;
            alt108 = dfa108.predict(input);
            switch (alt108) {
                case 1 :
                    // InternalTURN.g:5774:3: this_BoundElement_0= ruleBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getBoundElementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoundElement_0=ruleBoundElement();

                    state._fsp--;


                    			current = this_BoundElement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:5783:3: this_LongBoundElement_1= ruleLongBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getLongBoundElementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongBoundElement_1=ruleLongBoundElement();

                    state._fsp--;


                    			current = this_LongBoundElement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundOption"


    // $ANTLR start "entryRuleBoundElement"
    // InternalTURN.g:5795:1: entryRuleBoundElement returns [EObject current=null] : iv_ruleBoundElement= ruleBoundElement EOF ;
    public final EObject entryRuleBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundElement = null;


        try {
            // InternalTURN.g:5795:53: (iv_ruleBoundElement= ruleBoundElement EOF )
            // InternalTURN.g:5796:2: iv_ruleBoundElement= ruleBoundElement EOF
            {
             newCompositeNode(grammarAccess.getBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundElement=ruleBoundElement();

            state._fsp--;

             current =iv_ruleBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundElement"


    // $ANTLR start "ruleBoundElement"
    // InternalTURN.g:5802:1: ruleBoundElement returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleBoundElement() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalTURN.g:5808:2: ( ( ( ruleQualifiedName ) ) )
            // InternalTURN.g:5809:2: ( ( ruleQualifiedName ) )
            {
            // InternalTURN.g:5809:2: ( ( ruleQualifiedName ) )
            // InternalTURN.g:5810:3: ( ruleQualifiedName )
            {
            // InternalTURN.g:5810:3: ( ruleQualifiedName )
            // InternalTURN.g:5811:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoundElementRule());
            				}
            			

            				newCompositeNode(grammarAccess.getBoundElementAccess().getElemReferencedBoundElementCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundElement"


    // $ANTLR start "entryRuleLongBoundElement"
    // InternalTURN.g:5828:1: entryRuleLongBoundElement returns [EObject current=null] : iv_ruleLongBoundElement= ruleLongBoundElement EOF ;
    public final EObject entryRuleLongBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongBoundElement = null;


        try {
            // InternalTURN.g:5828:57: (iv_ruleLongBoundElement= ruleLongBoundElement EOF )
            // InternalTURN.g:5829:2: iv_ruleLongBoundElement= ruleLongBoundElement EOF
            {
             newCompositeNode(grammarAccess.getLongBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongBoundElement=ruleLongBoundElement();

            state._fsp--;

             current =iv_ruleLongBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongBoundElement"


    // $ANTLR start "ruleLongBoundElement"
    // InternalTURN.g:5835:1: ruleLongBoundElement returns [EObject current=null] : ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleLongBoundElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_from_0_0 = null;

        AntlrDatatypeRuleToken lv_to_2_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5841:2: ( ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) )
            // InternalTURN.g:5842:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            {
            // InternalTURN.g:5842:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            // InternalTURN.g:5843:3: ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) )
            {
            // InternalTURN.g:5843:3: ( (lv_from_0_0= ruleQualifiedName ) )
            // InternalTURN.g:5844:4: (lv_from_0_0= ruleQualifiedName )
            {
            // InternalTURN.g:5844:4: (lv_from_0_0= ruleQualifiedName )
            // InternalTURN.g:5845:5: lv_from_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getFromQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_108);
            lv_from_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_0_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,87,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLongBoundElementAccess().getFullStopFullStopKeyword_1());
            		
            // InternalTURN.g:5866:3: ( (lv_to_2_0= ruleQualifiedName ) )
            // InternalTURN.g:5867:4: (lv_to_2_0= ruleQualifiedName )
            {
            // InternalTURN.g:5867:4: (lv_to_2_0= ruleQualifiedName )
            // InternalTURN.g:5868:5: lv_to_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getToQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_to_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_2_0,
            						"org.xtext.example.mydsl.TURN.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongBoundElement"


    // $ANTLR start "entryRuleBinding"
    // InternalTURN.g:5889:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalTURN.g:5889:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalTURN.g:5890:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalTURN.g:5896:1: ruleBinding returns [EObject current=null] : (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_InBinding_0 = null;

        EObject this_OutBinding_1 = null;

        EObject this_ComponentBinding_2 = null;



        	enterRule();

        try {
            // InternalTURN.g:5902:2: ( (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) )
            // InternalTURN.g:5903:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            {
            // InternalTURN.g:5903:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            int alt109=3;
            alt109 = dfa109.predict(input);
            switch (alt109) {
                case 1 :
                    // InternalTURN.g:5904:3: this_InBinding_0= ruleInBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getInBindingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InBinding_0=ruleInBinding();

                    state._fsp--;


                    			current = this_InBinding_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:5913:3: this_OutBinding_1= ruleOutBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getOutBindingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutBinding_1=ruleOutBinding();

                    state._fsp--;


                    			current = this_OutBinding_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTURN.g:5922:3: this_ComponentBinding_2= ruleComponentBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getComponentBindingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComponentBinding_2=ruleComponentBinding();

                    state._fsp--;


                    			current = this_ComponentBinding_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleInBinding"
    // InternalTURN.g:5934:1: entryRuleInBinding returns [EObject current=null] : iv_ruleInBinding= ruleInBinding EOF ;
    public final EObject entryRuleInBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInBinding = null;


        try {
            // InternalTURN.g:5934:50: (iv_ruleInBinding= ruleInBinding EOF )
            // InternalTURN.g:5935:2: iv_ruleInBinding= ruleInBinding EOF
            {
             newCompositeNode(grammarAccess.getInBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInBinding=ruleInBinding();

            state._fsp--;

             current =iv_ruleInBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBinding"


    // $ANTLR start "ruleInBinding"
    // InternalTURN.g:5941:1: ruleInBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleInBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:5947:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTURN.g:5948:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTURN.g:5948:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTURN.g:5949:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTURN.g:5949:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:5950:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:5950:4: ( ruleQualifiedName )
            // InternalTURN.g:5951:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInBindingAccess().getMapStartStartPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_109); 

            			newLeafNode(otherlv_1, grammarAccess.getInBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTURN.g:5969:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTURN.g:5970:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,63,FOLLOW_54); 

            				newLeafNode(otherlv_2, grammarAccess.getInBindingAccess().getInKeyword_2_0());
            			
            // InternalTURN.g:5974:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTURN.g:5975:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTURN.g:5975:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTURN.g:5976:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getInBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getInBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.xtext.example.mydsl.TURN.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBinding"


    // $ANTLR start "entryRuleOutBinding"
    // InternalTURN.g:5998:1: entryRuleOutBinding returns [EObject current=null] : iv_ruleOutBinding= ruleOutBinding EOF ;
    public final EObject entryRuleOutBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutBinding = null;


        try {
            // InternalTURN.g:5998:51: (iv_ruleOutBinding= ruleOutBinding EOF )
            // InternalTURN.g:5999:2: iv_ruleOutBinding= ruleOutBinding EOF
            {
             newCompositeNode(grammarAccess.getOutBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutBinding=ruleOutBinding();

            state._fsp--;

             current =iv_ruleOutBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutBinding"


    // $ANTLR start "ruleOutBinding"
    // InternalTURN.g:6005:1: ruleOutBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleOutBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:6011:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTURN.g:6012:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTURN.g:6012:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTURN.g:6013:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTURN.g:6013:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:6014:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:6014:4: ( ruleQualifiedName )
            // InternalTURN.g:6015:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOutBindingAccess().getMapEndEndPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_110); 

            			newLeafNode(otherlv_1, grammarAccess.getOutBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTURN.g:6033:3: (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTURN.g:6034:4: otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,84,FOLLOW_54); 

            				newLeafNode(otherlv_2, grammarAccess.getOutBindingAccess().getOutKeyword_2_0());
            			
            // InternalTURN.g:6038:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTURN.g:6039:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTURN.g:6039:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTURN.g:6040:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getOutBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getOutBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.xtext.example.mydsl.TURN.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutBinding"


    // $ANTLR start "entryRuleComponentBinding"
    // InternalTURN.g:6062:1: entryRuleComponentBinding returns [EObject current=null] : iv_ruleComponentBinding= ruleComponentBinding EOF ;
    public final EObject entryRuleComponentBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentBinding = null;


        try {
            // InternalTURN.g:6062:57: (iv_ruleComponentBinding= ruleComponentBinding EOF )
            // InternalTURN.g:6063:2: iv_ruleComponentBinding= ruleComponentBinding EOF
            {
             newCompositeNode(grammarAccess.getComponentBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentBinding=ruleComponentBinding();

            state._fsp--;

             current =iv_ruleComponentBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentBinding"


    // $ANTLR start "ruleComponentBinding"
    // InternalTURN.g:6069:1: ruleComponentBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleComponentBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTURN.g:6075:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) )
            // InternalTURN.g:6076:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            {
            // InternalTURN.g:6076:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            // InternalTURN.g:6077:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) )
            {
            // InternalTURN.g:6077:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:6078:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:6078:4: ( ruleQualifiedName )
            // InternalTURN.g:6079:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentInComponentRefCrossReference_0_0());
            				
            pushFollow(FOLLOW_27);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComponentBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTURN.g:6097:3: ( ( ruleQualifiedName ) )
            // InternalTURN.g:6098:4: ( ruleQualifiedName )
            {
            // InternalTURN.g:6098:4: ( ruleQualifiedName )
            // InternalTURN.g:6099:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentOutComponentRefCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentBinding"


    // $ANTLR start "entryRuleFailureLabel"
    // InternalTURN.g:6117:1: entryRuleFailureLabel returns [EObject current=null] : iv_ruleFailureLabel= ruleFailureLabel EOF ;
    public final EObject entryRuleFailureLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailureLabel = null;


        try {
            // InternalTURN.g:6117:53: (iv_ruleFailureLabel= ruleFailureLabel EOF )
            // InternalTURN.g:6118:2: iv_ruleFailureLabel= ruleFailureLabel EOF
            {
             newCompositeNode(grammarAccess.getFailureLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailureLabel=ruleFailureLabel();

            state._fsp--;

             current =iv_ruleFailureLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureLabel"


    // $ANTLR start "ruleFailureLabel"
    // InternalTURN.g:6124:1: ruleFailureLabel returns [EObject current=null] : (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) ;
    public final EObject ruleFailureLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_failure_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTURN.g:6130:2: ( (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) )
            // InternalTURN.g:6131:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            {
            // InternalTURN.g:6131:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            // InternalTURN.g:6132:3: otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getFailureLabelAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
            		
            // InternalTURN.g:6136:3: ( (lv_failure_1_0= RULE_STRING ) )
            // InternalTURN.g:6137:4: (lv_failure_1_0= RULE_STRING )
            {
            // InternalTURN.g:6137:4: (lv_failure_1_0= RULE_STRING )
            // InternalTURN.g:6138:5: lv_failure_1_0= RULE_STRING
            {
            lv_failure_1_0=(Token)match(input,RULE_STRING,FOLLOW_111); 

            					newLeafNode(lv_failure_1_0, grammarAccess.getFailureLabelAccess().getFailureSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFailureLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"failure",
            						lv_failure_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,89,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getFailureLabelAccess().getRightSquareBracketRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureLabel"


    // $ANTLR start "entryRulePositiveInteger"
    // InternalTURN.g:6162:1: entryRulePositiveInteger returns [String current=null] : iv_rulePositiveInteger= rulePositiveInteger EOF ;
    public final String entryRulePositiveInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveInteger = null;


        try {
            // InternalTURN.g:6162:55: (iv_rulePositiveInteger= rulePositiveInteger EOF )
            // InternalTURN.g:6163:2: iv_rulePositiveInteger= rulePositiveInteger EOF
            {
             newCompositeNode(grammarAccess.getPositiveIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePositiveInteger=rulePositiveInteger();

            state._fsp--;

             current =iv_rulePositiveInteger.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositiveInteger"


    // $ANTLR start "rulePositiveInteger"
    // InternalTURN.g:6169:1: rulePositiveInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulePositiveInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalTURN.g:6175:2: (this_INT_0= RULE_INT )
            // InternalTURN.g:6176:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_0);
            	

            		newLeafNode(this_INT_0, grammarAccess.getPositiveIntegerAccess().getINTTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositiveInteger"


    // $ANTLR start "entryRuleText"
    // InternalTURN.g:6186:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalTURN.g:6186:45: (iv_ruleText= ruleText EOF )
            // InternalTURN.g:6187:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalTURN.g:6193:1: ruleText returns [EObject current=null] : ( (lv_content_0_0= ruleTextContent ) )+ ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalTURN.g:6199:2: ( ( (lv_content_0_0= ruleTextContent ) )+ )
            // InternalTURN.g:6200:2: ( (lv_content_0_0= ruleTextContent ) )+
            {
            // InternalTURN.g:6200:2: ( (lv_content_0_0= ruleTextContent ) )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==RULE_ID) ) {
                    int LA110_2 = input.LA(2);

                    if ( (LA110_2==EOF||(LA110_2>=RULE_ID && LA110_2<=RULE_INT)||LA110_2==15||LA110_2==25||LA110_2==27||LA110_2==80||(LA110_2>=90 && LA110_2<=93)) ) {
                        alt110=1;
                    }


                }
                else if ( (LA110_0==RULE_INT||LA110_0==25||LA110_0==80||(LA110_0>=90 && LA110_0<=93)) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalTURN.g:6201:3: (lv_content_0_0= ruleTextContent )
            	    {
            	    // InternalTURN.g:6201:3: (lv_content_0_0= ruleTextContent )
            	    // InternalTURN.g:6202:4: lv_content_0_0= ruleTextContent
            	    {

            	    				newCompositeNode(grammarAccess.getTextAccess().getContentTextContentParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_112);
            	    lv_content_0_0=ruleTextContent();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getTextRule());
            	    				}
            	    				add(
            	    					current,
            	    					"content",
            	    					lv_content_0_0,
            	    					"org.xtext.example.mydsl.TURN.TextContent");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt110 >= 1 ) break loop110;
                        EarlyExitException eee =
                            new EarlyExitException(110, input);
                        throw eee;
                }
                cnt110++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleTextContent"
    // InternalTURN.g:6222:1: entryRuleTextContent returns [String current=null] : iv_ruleTextContent= ruleTextContent EOF ;
    public final String entryRuleTextContent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTextContent = null;


        try {
            // InternalTURN.g:6222:51: (iv_ruleTextContent= ruleTextContent EOF )
            // InternalTURN.g:6223:2: iv_ruleTextContent= ruleTextContent EOF
            {
             newCompositeNode(grammarAccess.getTextContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextContent=ruleTextContent();

            state._fsp--;

             current =iv_ruleTextContent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextContent"


    // $ANTLR start "ruleTextContent"
    // InternalTURN.g:6229:1: ruleTextContent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTextContent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalTURN.g:6235:2: ( (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) )
            // InternalTURN.g:6236:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            {
            // InternalTURN.g:6236:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            int alt111=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt111=1;
                }
                break;
            case 90:
                {
                alt111=2;
                }
                break;
            case 25:
                {
                alt111=3;
                }
                break;
            case 91:
                {
                alt111=4;
                }
                break;
            case 92:
                {
                alt111=5;
                }
                break;
            case 93:
                {
                alt111=6;
                }
                break;
            case 80:
                {
                alt111=7;
                }
                break;
            case RULE_INT:
                {
                alt111=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // InternalTURN.g:6237:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getTextContentAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTURN.g:6245:3: kw= '@'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getCommercialAtKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalTURN.g:6251:3: kw= '#'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getNumberSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalTURN.g:6257:3: kw= '!'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getExclamationMarkKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalTURN.g:6263:3: kw= '%'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getPercentSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalTURN.g:6269:3: kw= '&'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalTURN.g:6275:3: kw= '*'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAsteriskKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalTURN.g:6281:3: this_INT_7= RULE_INT
                    {
                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_7);
                    		

                    			newLeafNode(this_INT_7, grammarAccess.getTextContentAccess().getINTTerminalRuleCall_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextContent"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTURN.g:6292:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTURN.g:6292:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTURN.g:6293:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTURN.g:6299:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTURN.g:6305:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTURN.g:6306:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTURN.g:6306:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTURN.g:6307:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_113); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTURN.g:6314:3: (kw= '.' this_ID_2= RULE_ID )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==76) ) {
                    int LA112_2 = input.LA(2);

                    if ( (LA112_2==RULE_ID) ) {
                        alt112=1;
                    }


                }


                switch (alt112) {
            	case 1 :
            	    // InternalTURN.g:6315:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,76,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_113); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop112;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleQualitativeLabel"
    // InternalTURN.g:6332:1: ruleQualitativeLabel returns [Enumerator current=null] : ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) ;
    public final Enumerator ruleQualitativeLabel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalTURN.g:6338:2: ( ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) )
            // InternalTURN.g:6339:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            {
            // InternalTURN.g:6339:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            int alt113=7;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt113=1;
                }
                break;
            case 95:
                {
                alt113=2;
                }
                break;
            case 96:
                {
                alt113=3;
                }
                break;
            case 97:
                {
                alt113=4;
                }
                break;
            case 98:
                {
                alt113=5;
                }
                break;
            case 99:
                {
                alt113=6;
                }
                break;
            case 100:
                {
                alt113=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalTURN.g:6340:3: (enumLiteral_0= 'denied' )
                    {
                    // InternalTURN.g:6340:3: (enumLiteral_0= 'denied' )
                    // InternalTURN.g:6341:4: enumLiteral_0= 'denied'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6348:3: (enumLiteral_1= 'weaklyDenied' )
                    {
                    // InternalTURN.g:6348:3: (enumLiteral_1= 'weaklyDenied' )
                    // InternalTURN.g:6349:4: enumLiteral_1= 'weaklyDenied'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6356:3: (enumLiteral_2= 'weaklySatisfied' )
                    {
                    // InternalTURN.g:6356:3: (enumLiteral_2= 'weaklySatisfied' )
                    // InternalTURN.g:6357:4: enumLiteral_2= 'weaklySatisfied'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTURN.g:6364:3: (enumLiteral_3= 'satisfied' )
                    {
                    // InternalTURN.g:6364:3: (enumLiteral_3= 'satisfied' )
                    // InternalTURN.g:6365:4: enumLiteral_3= 'satisfied'
                    {
                    enumLiteral_3=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTURN.g:6372:3: (enumLiteral_4= 'conflict' )
                    {
                    // InternalTURN.g:6372:3: (enumLiteral_4= 'conflict' )
                    // InternalTURN.g:6373:4: enumLiteral_4= 'conflict'
                    {
                    enumLiteral_4=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTURN.g:6380:3: (enumLiteral_5= 'unknown' )
                    {
                    // InternalTURN.g:6380:3: (enumLiteral_5= 'unknown' )
                    // InternalTURN.g:6381:4: enumLiteral_5= 'unknown'
                    {
                    enumLiteral_5=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTURN.g:6388:3: (enumLiteral_6= 'none' )
                    {
                    // InternalTURN.g:6388:3: (enumLiteral_6= 'none' )
                    // InternalTURN.g:6389:4: enumLiteral_6= 'none'
                    {
                    enumLiteral_6=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualitativeLabel"


    // $ANTLR start "ruleIntentionalElementType"
    // InternalTURN.g:6399:1: ruleIntentionalElementType returns [Enumerator current=null] : ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) ;
    public final Enumerator ruleIntentionalElementType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTURN.g:6405:2: ( ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) )
            // InternalTURN.g:6406:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            {
            // InternalTURN.g:6406:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            int alt114=6;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt114=1;
                }
                break;
            case 102:
                {
                alt114=2;
                }
                break;
            case 103:
                {
                alt114=3;
                }
                break;
            case 104:
                {
                alt114=4;
                }
                break;
            case 105:
                {
                alt114=5;
                }
                break;
            case 106:
                {
                alt114=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // InternalTURN.g:6407:3: (enumLiteral_0= 'softgoal' )
                    {
                    // InternalTURN.g:6407:3: (enumLiteral_0= 'softgoal' )
                    // InternalTURN.g:6408:4: enumLiteral_0= 'softgoal'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6415:3: (enumLiteral_1= 'goal' )
                    {
                    // InternalTURN.g:6415:3: (enumLiteral_1= 'goal' )
                    // InternalTURN.g:6416:4: enumLiteral_1= 'goal'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6423:3: (enumLiteral_2= 'task' )
                    {
                    // InternalTURN.g:6423:3: (enumLiteral_2= 'task' )
                    // InternalTURN.g:6424:4: enumLiteral_2= 'task'
                    {
                    enumLiteral_2=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTURN.g:6431:3: (enumLiteral_3= 'resource' )
                    {
                    // InternalTURN.g:6431:3: (enumLiteral_3= 'resource' )
                    // InternalTURN.g:6432:4: enumLiteral_3= 'resource'
                    {
                    enumLiteral_3=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTURN.g:6439:3: (enumLiteral_4= 'belief' )
                    {
                    // InternalTURN.g:6439:3: (enumLiteral_4= 'belief' )
                    // InternalTURN.g:6440:4: enumLiteral_4= 'belief'
                    {
                    enumLiteral_4=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTURN.g:6447:3: (enumLiteral_5= 'indicator' )
                    {
                    // InternalTURN.g:6447:3: (enumLiteral_5= 'indicator' )
                    // InternalTURN.g:6448:4: enumLiteral_5= 'indicator'
                    {
                    enumLiteral_5=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElementType"


    // $ANTLR start "ruleContributionType"
    // InternalTURN.g:6458:1: ruleContributionType returns [Enumerator current=null] : ( (enumLiteral_0= 'undefined' ) | (enumLiteral_1= 'make' ) | (enumLiteral_2= 'help' ) | (enumLiteral_3= 'somePositive' ) | (enumLiteral_4= 'unknown' ) | (enumLiteral_5= 'someNegative' ) | (enumLiteral_6= 'hurt' ) | (enumLiteral_7= 'break' ) ) ;
    public final Enumerator ruleContributionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalTURN.g:6464:2: ( ( (enumLiteral_0= 'undefined' ) | (enumLiteral_1= 'make' ) | (enumLiteral_2= 'help' ) | (enumLiteral_3= 'somePositive' ) | (enumLiteral_4= 'unknown' ) | (enumLiteral_5= 'someNegative' ) | (enumLiteral_6= 'hurt' ) | (enumLiteral_7= 'break' ) ) )
            // InternalTURN.g:6465:2: ( (enumLiteral_0= 'undefined' ) | (enumLiteral_1= 'make' ) | (enumLiteral_2= 'help' ) | (enumLiteral_3= 'somePositive' ) | (enumLiteral_4= 'unknown' ) | (enumLiteral_5= 'someNegative' ) | (enumLiteral_6= 'hurt' ) | (enumLiteral_7= 'break' ) )
            {
            // InternalTURN.g:6465:2: ( (enumLiteral_0= 'undefined' ) | (enumLiteral_1= 'make' ) | (enumLiteral_2= 'help' ) | (enumLiteral_3= 'somePositive' ) | (enumLiteral_4= 'unknown' ) | (enumLiteral_5= 'someNegative' ) | (enumLiteral_6= 'hurt' ) | (enumLiteral_7= 'break' ) )
            int alt115=8;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt115=1;
                }
                break;
            case 108:
                {
                alt115=2;
                }
                break;
            case 109:
                {
                alt115=3;
                }
                break;
            case 110:
                {
                alt115=4;
                }
                break;
            case 99:
                {
                alt115=5;
                }
                break;
            case 111:
                {
                alt115=6;
                }
                break;
            case 112:
                {
                alt115=7;
                }
                break;
            case 113:
                {
                alt115=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalTURN.g:6466:3: (enumLiteral_0= 'undefined' )
                    {
                    // InternalTURN.g:6466:3: (enumLiteral_0= 'undefined' )
                    // InternalTURN.g:6467:4: enumLiteral_0= 'undefined'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getUndefinedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContributionTypeAccess().getUndefinedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6474:3: (enumLiteral_1= 'make' )
                    {
                    // InternalTURN.g:6474:3: (enumLiteral_1= 'make' )
                    // InternalTURN.g:6475:4: enumLiteral_1= 'make'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6482:3: (enumLiteral_2= 'help' )
                    {
                    // InternalTURN.g:6482:3: (enumLiteral_2= 'help' )
                    // InternalTURN.g:6483:4: enumLiteral_2= 'help'
                    {
                    enumLiteral_2=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTURN.g:6490:3: (enumLiteral_3= 'somePositive' )
                    {
                    // InternalTURN.g:6490:3: (enumLiteral_3= 'somePositive' )
                    // InternalTURN.g:6491:4: enumLiteral_3= 'somePositive'
                    {
                    enumLiteral_3=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTURN.g:6498:3: (enumLiteral_4= 'unknown' )
                    {
                    // InternalTURN.g:6498:3: (enumLiteral_4= 'unknown' )
                    // InternalTURN.g:6499:4: enumLiteral_4= 'unknown'
                    {
                    enumLiteral_4=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTURN.g:6506:3: (enumLiteral_5= 'someNegative' )
                    {
                    // InternalTURN.g:6506:3: (enumLiteral_5= 'someNegative' )
                    // InternalTURN.g:6507:4: enumLiteral_5= 'someNegative'
                    {
                    enumLiteral_5=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTURN.g:6514:3: (enumLiteral_6= 'hurt' )
                    {
                    // InternalTURN.g:6514:3: (enumLiteral_6= 'hurt' )
                    // InternalTURN.g:6515:4: enumLiteral_6= 'hurt'
                    {
                    enumLiteral_6=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalTURN.g:6522:3: (enumLiteral_7= 'break' )
                    {
                    // InternalTURN.g:6522:3: (enumLiteral_7= 'break' )
                    // InternalTURN.g:6523:4: enumLiteral_7= 'break'
                    {
                    enumLiteral_7=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionType"


    // $ANTLR start "ruleImportanceType"
    // InternalTURN.g:6533:1: ruleImportanceType returns [Enumerator current=null] : ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) ;
    public final Enumerator ruleImportanceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTURN.g:6539:2: ( ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) )
            // InternalTURN.g:6540:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            {
            // InternalTURN.g:6540:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            int alt116=4;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt116=1;
                }
                break;
            case 115:
                {
                alt116=2;
                }
                break;
            case 116:
                {
                alt116=3;
                }
                break;
            case 100:
                {
                alt116=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalTURN.g:6541:3: (enumLiteral_0= 'high' )
                    {
                    // InternalTURN.g:6541:3: (enumLiteral_0= 'high' )
                    // InternalTURN.g:6542:4: enumLiteral_0= 'high'
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6549:3: (enumLiteral_1= 'medium' )
                    {
                    // InternalTURN.g:6549:3: (enumLiteral_1= 'medium' )
                    // InternalTURN.g:6550:4: enumLiteral_1= 'medium'
                    {
                    enumLiteral_1=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6557:3: (enumLiteral_2= 'low' )
                    {
                    // InternalTURN.g:6557:3: (enumLiteral_2= 'low' )
                    // InternalTURN.g:6558:4: enumLiteral_2= 'low'
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTURN.g:6565:3: (enumLiteral_3= 'none' )
                    {
                    // InternalTURN.g:6565:3: (enumLiteral_3= 'none' )
                    // InternalTURN.g:6566:4: enumLiteral_3= 'none'
                    {
                    enumLiteral_3=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportanceType"


    // $ANTLR start "ruleDecompositionType"
    // InternalTURN.g:6576:1: ruleDecompositionType returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) ;
    public final Enumerator ruleDecompositionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTURN.g:6582:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) )
            // InternalTURN.g:6583:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            {
            // InternalTURN.g:6583:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            int alt117=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt117=1;
                }
                break;
            case 77:
                {
                alt117=2;
                }
                break;
            case 117:
                {
                alt117=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // InternalTURN.g:6584:3: (enumLiteral_0= 'and' )
                    {
                    // InternalTURN.g:6584:3: (enumLiteral_0= 'and' )
                    // InternalTURN.g:6585:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6592:3: (enumLiteral_1= 'or' )
                    {
                    // InternalTURN.g:6592:3: (enumLiteral_1= 'or' )
                    // InternalTURN.g:6593:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6600:3: (enumLiteral_2= 'xor' )
                    {
                    // InternalTURN.g:6600:3: (enumLiteral_2= 'xor' )
                    // InternalTURN.g:6601:4: enumLiteral_2= 'xor'
                    {
                    enumLiteral_2=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecompositionType"


    // $ANTLR start "ruleWAITKIND"
    // InternalTURN.g:6611:1: ruleWAITKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) ;
    public final Enumerator ruleWAITKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTURN.g:6617:2: ( ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) )
            // InternalTURN.g:6618:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            {
            // InternalTURN.g:6618:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==118) ) {
                alt118=1;
            }
            else if ( (LA118_0==119) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalTURN.g:6619:3: (enumLiteral_0= 'persistent' )
                    {
                    // InternalTURN.g:6619:3: (enumLiteral_0= 'persistent' )
                    // InternalTURN.g:6620:4: enumLiteral_0= 'persistent'
                    {
                    enumLiteral_0=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6627:3: (enumLiteral_1= 'transient' )
                    {
                    // InternalTURN.g:6627:3: (enumLiteral_1= 'transient' )
                    // InternalTURN.g:6628:4: enumLiteral_1= 'transient'
                    {
                    enumLiteral_1=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getWAITKINDAccess().getTransientEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getWAITKINDAccess().getTransientEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWAITKIND"


    // $ANTLR start "ruleSTUBTYPE"
    // InternalTURN.g:6638:1: ruleSTUBTYPE returns [Enumerator current=null] : ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) ) ;
    public final Enumerator ruleSTUBTYPE() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTURN.g:6644:2: ( ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) ) )
            // InternalTURN.g:6645:2: ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) )
            {
            // InternalTURN.g:6645:2: ( (enumLiteral_0= 'synchronizing' ) | (enumLiteral_1= 'blocking' ) )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==120) ) {
                alt119=1;
            }
            else if ( (LA119_0==121) ) {
                alt119=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    // InternalTURN.g:6646:3: (enumLiteral_0= 'synchronizing' )
                    {
                    // InternalTURN.g:6646:3: (enumLiteral_0= 'synchronizing' )
                    // InternalTURN.g:6647:4: enumLiteral_0= 'synchronizing'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getSTUBTYPEAccess().getSynchronizingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSTUBTYPEAccess().getSynchronizingEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6654:3: (enumLiteral_1= 'blocking' )
                    {
                    // InternalTURN.g:6654:3: (enumLiteral_1= 'blocking' )
                    // InternalTURN.g:6655:4: enumLiteral_1= 'blocking'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getSTUBTYPEAccess().getBlockingEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSTUBTYPEAccess().getBlockingEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTUBTYPE"


    // $ANTLR start "ruleCOMPONENTKIND"
    // InternalTURN.g:6665:1: ruleCOMPONENTKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) ;
    public final Enumerator ruleCOMPONENTKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTURN.g:6671:2: ( ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) )
            // InternalTURN.g:6672:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            {
            // InternalTURN.g:6672:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            int alt120=6;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt120=1;
                }
                break;
            case 123:
                {
                alt120=2;
                }
                break;
            case 124:
                {
                alt120=3;
                }
                break;
            case 125:
                {
                alt120=4;
                }
                break;
            case 32:
                {
                alt120=5;
                }
                break;
            case 126:
                {
                alt120=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalTURN.g:6673:3: (enumLiteral_0= 'team' )
                    {
                    // InternalTURN.g:6673:3: (enumLiteral_0= 'team' )
                    // InternalTURN.g:6674:4: enumLiteral_0= 'team'
                    {
                    enumLiteral_0=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTURN.g:6681:3: (enumLiteral_1= 'object' )
                    {
                    // InternalTURN.g:6681:3: (enumLiteral_1= 'object' )
                    // InternalTURN.g:6682:4: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTURN.g:6689:3: (enumLiteral_2= 'process' )
                    {
                    // InternalTURN.g:6689:3: (enumLiteral_2= 'process' )
                    // InternalTURN.g:6690:4: enumLiteral_2= 'process'
                    {
                    enumLiteral_2=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTURN.g:6697:3: (enumLiteral_3= 'agent' )
                    {
                    // InternalTURN.g:6697:3: (enumLiteral_3= 'agent' )
                    // InternalTURN.g:6698:4: enumLiteral_3= 'agent'
                    {
                    enumLiteral_3=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTURN.g:6705:3: (enumLiteral_4= 'actor' )
                    {
                    // InternalTURN.g:6705:3: (enumLiteral_4= 'actor' )
                    // InternalTURN.g:6706:4: enumLiteral_4= 'actor'
                    {
                    enumLiteral_4=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTURN.g:6713:3: (enumLiteral_5= 'parent' )
                    {
                    // InternalTURN.g:6713:3: (enumLiteral_5= 'parent' )
                    // InternalTURN.g:6714:4: enumLiteral_5= 'parent'
                    {
                    enumLiteral_5=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getParentEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCOMPONENTKINDAccess().getParentEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOMPONENTKIND"

    // Delegated rules


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA109 dfa109 = new DFA109(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\1\15\uffff";
    static final String dfa_3s = "\1\13\15\uffff";
    static final String dfa_4s = "\1\71\15\uffff";
    static final String dfa_5s = "\1\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String dfa_6s = "\1\0\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\10\1\15\10\uffff\1\13\5\uffff\1\14\3\uffff\1\12\7\uffff\1\3\1\4\5\uffff\1\5\3\uffff\1\5\1\6\1\7\2\uffff\2\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_4_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_5_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_6_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_7_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_8_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_9_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_10_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_actors_11_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_14= 'metadata' otherlv_15= '{' ( (lv_metadata_16_0= ruleMetadata ) )* otherlv_17= '}' ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_0==EOF) ) {s = 1;}

                        else if ( LA12_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {s = 2;}

                        else if ( LA12_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {s = 3;}

                        else if ( LA12_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {s = 4;}

                        else if ( ( LA12_0 == 47 || LA12_0 == 51 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {s = 5;}

                        else if ( LA12_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {s = 6;}

                        else if ( LA12_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {s = 7;}

                        else if ( LA12_0 == 12 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {s = 8;}

                        else if ( LA12_0 >= 56 && LA12_0 <= 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {s = 9;}

                        else if ( LA12_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {s = 10;}

                        else if ( LA12_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {s = 11;}

                        else if ( LA12_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {s = 12;}

                        else if ( LA12_0 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {s = 13;}

                         
                        input.seek(index12_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\6\uffff";
    static final String dfa_9s = "\1\5\1\27\1\uffff\1\5\1\uffff\1\27";
    static final String dfa_10s = "\1\35\1\114\1\uffff\1\5\1\uffff\1\114";
    static final String dfa_11s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\27\uffff\1\2",
            "\1\4\1\uffff\1\4\4\uffff\1\2\55\uffff\1\3",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\1\4\4\uffff\1\2\55\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "972:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\1\5\1\31\3\uffff\1\5\1\4\1\31\2\43";
    static final String dfa_16s = "\2\165\3\uffff\2\5\3\165";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\3\5\uffff";
    static final String dfa_18s = "\12\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\35\uffff\1\2\3\uffff\1\4\45\uffff\1\3\1\uffff\1\3\45\uffff\1\3",
            "\1\6\11\uffff\1\2\3\uffff\1\4\44\uffff\1\5\1\3\1\uffff\1\3\45\uffff\1\3",
            "",
            "",
            "",
            "\1\7",
            "\1\11\1\10",
            "\1\6\11\uffff\1\2\3\uffff\1\4\44\uffff\1\5\1\3\1\uffff\1\3\45\uffff\1\3",
            "\1\2\3\uffff\1\4\45\uffff\1\3\1\uffff\1\3\45\uffff\1\3",
            "\1\2\3\uffff\1\4\45\uffff\1\3\1\uffff\1\3\45\uffff\1\3"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1489:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )";
        }
    }
    static final String dfa_20s = "\11\uffff";
    static final String dfa_21s = "\1\5\1\uffff\2\5\1\4\1\uffff\3\5";
    static final String dfa_22s = "\1\176\1\uffff\1\176\2\5\1\uffff\3\176";
    static final String dfa_23s = "\1\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String dfa_24s = "\11\uffff}>";
    static final String[] dfa_25s = {
            "\1\2\11\uffff\1\1\20\uffff\1\1\31\uffff\1\1\1\uffff\2\1\30\uffff\1\1\43\uffff\5\1",
            "",
            "\1\1\11\uffff\1\1\7\uffff\1\1\1\uffff\1\4\5\uffff\1\5\1\1\53\uffff\1\3\11\uffff\1\1\43\uffff\5\1",
            "\1\6",
            "\1\10\1\7",
            "",
            "\1\1\11\uffff\1\1\7\uffff\1\1\1\uffff\1\4\5\uffff\1\5\1\1\53\uffff\1\3\11\uffff\1\1\43\uffff\5\1",
            "\1\1\11\uffff\1\1\7\uffff\1\1\7\uffff\1\5\1\1\65\uffff\1\1\43\uffff\5\1",
            "\1\1\11\uffff\1\1\7\uffff\1\1\7\uffff\1\5\1\1\65\uffff\1\1\43\uffff\5\1"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()* loopback of 3142:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*";
        }
    }
    static final String dfa_26s = "\1\101\3\uffff\2\106\4\uffff";
    static final String dfa_27s = "\1\167\3\uffff\2\107\4\uffff";
    static final String dfa_28s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\1\7";
    static final String[] dfa_29s = {
            "\1\2\1\3\3\1\1\6\1\10\1\uffff\1\11\1\7\53\uffff\1\4\1\5",
            "",
            "",
            "",
            "\1\6\1\10",
            "\1\6\1\10",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_18;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "3745:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )";
        }
    }
    static final String dfa_30s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_31s = "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String dfa_32s = "\1\122\1\176\1\uffff\1\5\1\uffff\1\176";
    static final String dfa_33s = "\2\uffff\1\1\1\uffff\1\2\1\uffff";
    static final String[] dfa_34s = {
            "\1\1\114\uffff\1\2",
            "\1\4\10\uffff\2\4\11\uffff\1\2\1\4\5\uffff\1\4\31\uffff\1\4\1\uffff\3\4\15\uffff\1\3\1\uffff\1\4\1\uffff\1\4\1\uffff\1\2\1\uffff\1\4\1\uffff\1\4\43\uffff\5\4",
            "",
            "\1\5",
            "",
            "\1\4\10\uffff\2\4\11\uffff\1\2\1\4\5\uffff\1\4\31\uffff\1\4\1\uffff\3\4\15\uffff\1\3\1\uffff\1\4\1\uffff\1\4\1\uffff\1\2\1\uffff\1\4\1\uffff\1\4\43\uffff\5\4"
    };
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_12;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5134:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )";
        }
    }
    static final String dfa_35s = "\3\5\2\uffff\1\5";
    static final String dfa_36s = "\1\5\1\176\1\5\2\uffff\1\176";
    static final String dfa_37s = "\3\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_38s = {
            "\1\1",
            "\1\4\11\uffff\1\4\10\uffff\1\4\7\uffff\1\4\53\uffff\1\2\11\uffff\1\4\1\3\42\uffff\5\4",
            "\1\5",
            "",
            "",
            "\1\4\11\uffff\1\4\10\uffff\1\4\7\uffff\1\4\53\uffff\1\2\11\uffff\1\4\1\3\42\uffff\5\4"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA108 extends DFA {

        public DFA108(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 108;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_12;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "5773:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )";
        }
    }
    static final String dfa_39s = "\10\uffff";
    static final String dfa_40s = "\1\5\1\37\2\5\1\37\3\uffff";
    static final String dfa_41s = "\1\5\1\114\1\5\1\124\1\114\3\uffff";
    static final String dfa_42s = "\5\uffff\1\1\1\2\1\3";
    static final String dfa_43s = "\10\uffff}>";
    static final String[] dfa_44s = {
            "\1\1",
            "\1\3\54\uffff\1\2",
            "\1\4",
            "\1\7\71\uffff\1\5\24\uffff\1\6",
            "\1\3\54\uffff\1\2",
            "",
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "5903:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0338830110407802L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0338830110403802L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000060L,0x000000003C010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200008000L,0x000007E000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00C0000000000040L,0x001C001000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000008000L,0x000007E000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008E00008020L,0x002000000000A000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008C00008020L,0x002000000000A000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008800008020L,0x002000000000A000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000802000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00C0000000000040L,0x001FF81800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000002000020L,0x002000000000A000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000020L,0x002000000000A000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000008002000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000040000028020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040000008020L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000580000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x00C0000000000040L,0x001C001FC0000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000480000008000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x3400000100008020L,0x7C00000000400000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000100008020L,0x7C00000000400000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0800000006000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0800000004000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x030000000002A800L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x4000000000000022L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x00C00000000006FEL});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x00C00000000006FEL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000004000022L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000004008000L,0x0000000000000101L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000004008000L,0x0000000000000001L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000001L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000004000022L,0x0000000001000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000006000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000004000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000004000020L,0x0000000000001000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000006000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000004000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000004004020L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000008000L,0x0000000000010000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x8000000000000020L,0x0000000000040000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000020L,0x0000000000040000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000002000020L,0x0000000000040000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x4000000000004002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000008000L,0x0000000000100000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000004000020L,0x0000000000280000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000082000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000020L,0x0000000000200000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000100000020L,0x7C00000000000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000002000062L,0x000000003C010000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});

}
