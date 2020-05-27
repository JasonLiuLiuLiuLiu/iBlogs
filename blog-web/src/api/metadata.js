import request from '../utils/request'

export function categories(pageNum, pageSize) {
  return request({
    url: '/metadata/categories',
    method: 'get',
    params: {
      pageNum,
      pageSize
    }
  })
}

export function tags(pageNum, pageSize) {
  return request({
    url: '/metadata/tags',
    method: 'get',
    params: {
      pageNum,
      pageSize
    }
  })
}
