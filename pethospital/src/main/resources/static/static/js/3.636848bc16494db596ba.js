webpackJsonp([3],{IJt2:function(t,e){},luPR:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s={data:function(){return{chapters:[],chapter:{},chapterIndex:0,nextShow:!0,prevShow:!0}},created:function(){this.chapterIndex=this.$route.query.pid,this.getDate()},methods:{getDate:function(){var t=this;this.$ajax.post("/api/getSections?cid="+t.$route.query.cid).then(function(e){0===e.data.code?(t.chapters=e.data.data,t.setChapter(t.chapterIndex)):t.goindex()}).catch(function(t){console.log(t)})},setChapter:function(t){this.chapter=this.chapters[t-1]},next:function(){this.chapterIndex+1<=this.chapters.length&&(this.setChapter(++this.chapterIndex),window.scrollTo(0,0))},goindex:function(){this.$router.push("/index")},prev:function(){this.chapterIndex-1>0&&(this.setChapter(--this.chapterIndex),window.scrollTo(0,0))}},watch:{chapterIndex:function(t){this.prevShow=1!==t,t===this.chapters.length?this.nextShow=!1:this.nextShow=!0},chapter:function(t){void 0===t&&this.$router.push("/index")}}},i={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"Rdetail"},[void 0!=t.chapter?n("div",{staticClass:"content"},[n("div",{staticClass:"title"},[t._v(" 《"+t._s(t.$route.query.n)+"》 - "),n("span",[t._v("第 "+t._s(t.chapter.chapter)+" 章:  "+t._s(t.chapter.title))])]),t._v(" "),n("div",{staticClass:"section"},[n("img",{attrs:{src:t.chapter.content,alt:""}})])]):t._e(),t._v(" "),n("div",{staticClass:"prevNext"},[n("p",{directives:[{name:"show",rawName:"v-show",value:t.prevShow,expression:"prevShow"}],on:{click:function(e){t.prev()}}},[n("i",{staticClass:"el-icon-arrow-up"}),n("br"),t._v("上一章")]),t._v(" "),n("p",{directives:[{name:"show",rawName:"v-show",value:t.nextShow,expression:"nextShow"}],on:{click:function(e){t.next()}}},[t._v("下一章"),n("br"),n("i",{staticClass:"el-icon-arrow-down"})])])])},staticRenderFns:[]};var a=n("VU/8")(s,i,!1,function(t){n("IJt2")},"data-v-f7ee4eee",null);e.default=a.exports}});
//# sourceMappingURL=3.636848bc16494db596ba.js.map