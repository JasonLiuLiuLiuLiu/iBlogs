
cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=http://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=http://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg http://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
exclude=kube*
EOF
 
# 将 SELinux 设置为 permissive 模式(将其禁用)
setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config
systemctl disable --now firewalld  # 关闭防火墙
yum install -y kubelet kubeadm kubectl --disableexcludes=kubernetes
 
systemctl enable kubelet && systemctl start kubelet

#（1）使用 vi 命令编辑相关文件：

#vi /etc/sysctl.conf

#（2）在文件中添加如下内容后，保存退出。

#net.bridge.bridge-nf-call-ip6tables = 1
#net.bridge.bridge-nf-call-iptables = 1
#net.ipv4.ip_forward = 1
#
#（3）最后执行如下命令即可：

#sysctl --system

#（1）首先执行如下命令将其关闭：
#
# swapoff -a
#
#（2）接着编辑 /etc/fstab 文件。
#
# vi /etc/fstab
#
#（3）将 /dev/mapper/centos-swap swap swap default 0 0 这一行前面加个 # 号将其注释掉。


# Master 节点的安装配置

kubeadm init --pod-network-cidr=10.244.0.0/16

docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/kube-apiserver:v1.18.5
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/kube-controller-manager:v1.18.5
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/kube-scheduler:v1.18.5
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/kube-proxy:v1.18.5
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/pause:3.2
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/etcd:3.4.3-0
docker pull registry.cn-hangzhou.aliyuncs.com/google_containers/coredns:1.6.7

docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/kube-apiserver:v1.18.5 k8s.gcr.io/kube-apiserver:v1.18.5
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/kube-controller-manager:v1.18.5 k8s.gcr.io/kube-controller-manager:v1.18.5
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/kube-scheduler:v1.18.5 k8s.gcr.io/kube-scheduler:v1.18.5
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/kube-proxy:v1.18.5 k8s.gcr.io/kube-proxy:v1.18.5
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/pause:3.2 k8s.gcr.io/pause:3.2
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/etcd:3.4.3-0 k8s.gcr.io/etcd:3.4.3-0
docker tag registry.cn-hangzhou.aliyuncs.com/google_containers/coredns:1.6.7 k8s.gcr.io/coredns:1.6.7

docker pull k8s.gcr.io/kube-apiserver:v1.18.5
docker pull k8s.gcr.io/kube-controller-manager:v1.18.5
docker pull k8s.gcr.io/kube-scheduler:v1.18.5
docker pull k8s.gcr.io/kube-proxy:v1.18.5
docker pull k8s.gcr.io/pause:3.2
docker pull k8s.gcr.io/etcd:3.4.3-0
docker pull k8s.gcr.io/coredns:1.6.7


