import request from '../utils/request'

export function archive(pageNum, pageSize) {
  return request({
    url: '/content/archive',
    method: 'get',
    data: {
      pageNum,
      pageSize
    }
  })
}

export function category(category, pageNum, pageSize) {
  return request({
    url: '/content/category',
    method: 'get',
    data: {
      category,
      pageNum,
      pageSize
    }
  })
}

export function tag(tag, pageNum, pageSize) {
  return request({
    url: '/content/tag',
    method: 'get',
    data: {
      tag,
      pageNum,
      pageSize
    }
  })
}

export function index(url) {
  return request({
    url: '/content/index',
    method: 'get',
    data: {
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
