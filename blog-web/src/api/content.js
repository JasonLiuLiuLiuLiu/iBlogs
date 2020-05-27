import request from '../utils/request'

export function category(meta, pageNum, pageSize) {
  return request({
    url: '/content/category',
    method: 'post',
    data: {
      meta,
      pageNum,
      pageSize
    }
  })
}

export function tag(meta, pageNum, pageSize) {
  return request({
    url: '/content/tag',
    method: 'post',
    data: {
      meta,
      pageNum,
      pageSize
    }
  })
}

export function index(url) {
  return request({
    url: '/content/index',
    method: 'get',
    params: {
      url
    }
  })
}

export function page(pageNum, pageSize) {
  return request({
    url: '/content/page',
    method: 'get',
    params: {
      pageNum,
      pageSize
    }
  })
}

export function archive(archive, pageNum, pageSize) {
  return request({
    url: '/content/byArchive',
    method: 'get',
    params: {
      archive,
      pageNum,
      pageSize
    }
  })
}

export function archives() {
  return request({
    url: '/content/archives',
    method: 'get'
  })
}

export function search(keyword, pageNum, pageSize) {
  return request({
    url: '/content/search',
    method: 'get',
    params: {
      keyword,
      pageNum,
      pageSize
    }
  })
}
