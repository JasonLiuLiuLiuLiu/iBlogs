<template>
  <div class="lists-navigator clearfix">
    @{ var pageInfo = Model.Contents;
    <ol class="page-navigator">
      @if (pageInfo.HasPrevPage)
      {
      <li class="prev"><a href="/index/@Model.OrderType/@(!string.IsNullOrWhiteSpace(Model.DisplayMeta)?Model.DisplayMeta+'/':" ")@pageInfo.PrevPage">←</a></li>
      }

      @foreach (var navIndex in pageInfo.NavPageNums)
      {
      <li class="@(pageInfo.PageNum==navIndex?" current":"")"><a href="/index/@Model.OrderType/@(!string.IsNullOrWhiteSpace(Model.DisplayMeta)?Model.DisplayMeta+'/':" ")@navIndex">@navIndex</a></li>
      }

      @if (pageInfo.HasNextPage)
      {
      <li class="next"><a href="/index/@Model.OrderType/@(!string.IsNullOrWhiteSpace(Model.DisplayMeta)?Model.DisplayMeta+'/':" ")@pageInfo.NextPage">→</a></li>
      }
    </ol>
    }
  </div>
</template>
<script>

</script>
<style>

</style>
